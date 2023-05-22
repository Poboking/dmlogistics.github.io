package rog.sziit.dynamicplus.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sun.jersey.core.impl.provider.entity.DataSourceProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import rog.sziit.dynamicplus.models.LogisticsDataEntity;

/**
 * @author:poboking
 * @version:1.0
 * @time:2023/5/22 9:46
 */
@Mapper
@DS("#{dataSourceProvider.getDataSourceName()}")
public interface LogisticsMapper extends BaseMapper<LogisticsDataEntity> {
    /**
     * 用于配置@DS注解的Provider
     * @param id
     * @return DataSourceName
     */
    @SelectProvider(type = DataSourceProvider.class, method = "getDataSourceName")
    String getDataSourceName(String id);
}
