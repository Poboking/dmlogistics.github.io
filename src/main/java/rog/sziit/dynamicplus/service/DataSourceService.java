package rog.sziit.dynamicplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import rog.sziit.dynamicplus.models.DataSourceEntity;

import java.util.Map;

/**
 * @author:poboking
 * @version:1.0
 * @time:2023/5/21 19:58
 */
public interface DataSourceService extends IService<DataSourceEntity> {

    /**
     * 更新数据源
     */
    public boolean updateDataSource(String name,DataSourceEntity dataSourceEntity);
    /**
     * 删除数据源
     */
    public boolean removeDataSource(String name);
    /**
     * 新增数据源
     */
    boolean addDataSource(DataSourceEntity dataSourceEntity);

    /**
     * 获取数据源列表
     */
    public Map<String ,DataSourceEntity> getDataSourceEntityMap();
}
