package rog.sziit.dynamicplus.service.impl;

import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rog.sziit.dynamicplus.mapper.DataSourceMapper;
import rog.sziit.dynamicplus.models.DataSourceEntity;
import rog.sziit.dynamicplus.service.DataSourceService;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @author:poboking
 * @version:1.0
 * @time:2023/5/21 21:35
 */
@Service
public class DataSourceManagementServiceImpl extends ServiceImpl<DataSourceMapper, DataSourceEntity> implements DataSourceService{
    private final DataSourceMapper dataSourceMapper;
    private final DynamicRoutingDataSource dynamicDataSource;
    private final HikariDataSource baseDataSource;
    private final Map<String, DataSourceEntity> dataSourceEntityMap;

    @Autowired
    public DataSourceManagementServiceImpl(DataSourceMapper dataSourceMapper, DynamicRoutingDataSource dynamicDataSource, HikariDataSource baseDataSource, Map<String, DataSourceEntity> dataSourceEntityMap) {
        this.dataSourceMapper = dataSourceMapper;
        this.dynamicDataSource = dynamicDataSource;
        this.baseDataSource = baseDataSource;
        this.dataSourceEntityMap = dataSourceEntityMap;
    }

    @Override
    public boolean addDataSource(DataSourceEntity dataSourceEntity) {

        try {
            dataSourceEntityMap.put(dataSourceEntity.getName(),dataSourceEntity);
            DataSource dataSource = createDataSource(dataSourceEntity);
            dynamicDataSource.addDataSource(dataSourceEntity.getName(), dataSource);
            return true;
        }catch (Exception e){
         return false;
        }
    }

    @Override
    public boolean removeDataSource(String name) {
        try {
            dataSourceEntityMap.remove(name);
            dynamicDataSource.removeDataSource(name);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public boolean updateDataSource(String name,DataSourceEntity dataSourceEntity){
        try {
            if (dynamicDataSource.getDataSource(name)!=null){
                dynamicDataSource.removeDataSource(name);
            }
            dynamicDataSource.addDataSource(name, createDataSource(dataSourceEntity));
            dataSourceEntityMap.put(name, dataSourceEntity);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Map<String ,DataSourceEntity> getDataSourceEntityMap() {
        return dataSourceEntityMap;
    }
    public DataSource getDataSource(String name) {
        return dynamicDataSource.getDataSource(name);
    }



    private DataSource createDataSource(DataSourceEntity dataSourceEntity) {
        HikariConfig config = new HikariConfig();
        config.setPoolName(dataSourceEntity.getPoolName() + "Pool");
        config.setJdbcUrl(dataSourceEntity.getJdbcUrl());
        config.setUsername(dataSourceEntity.getName());
        config.setPassword(dataSourceEntity.getPassword());
        config.setDriverClassName(dataSourceEntity.getDriverClassName());

        baseDataSource.setDataSource(new HikariDataSource(config));
        return baseDataSource;
    }
}
