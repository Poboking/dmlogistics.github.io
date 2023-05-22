package rog.sziit.dynamicplus.utils;

import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @author:poboking
 * @version:1.0
 * @time:2023/5/21 19:31
 */


@Component("dataSourceManager")
public class DataSourceManager extends AbstractRoutingDataSource {
    private final DynamicRoutingDataSource dynamicDataSource;

    @Autowired
    public DataSourceManager(DynamicRoutingDataSource dynamicDataSource) {
        this.dynamicDataSource = dynamicDataSource;
    }

    // 实现AbstractRoutingDataSource类中的determineCurrentLookupKey()方法，
    // 返回当前线程绑定的动态数据源名称。

    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.getDataSource();
    }

    // 实现AbstractRoutingDataSource类中的determineTargetDataSource()方法，
    // 如果当前线程绑定的数据源名称存在于动态数据源中，则返回对应的DataSource对象，
    // 否则调用父类方法获取默认数据源。

    @Override
    protected DataSource determineTargetDataSource() {
        String dataSourceName = DynamicDataSourceContextHolder.getDataSource();
        if (dataSourceName != null && dynamicDataSource.getDataSources().containsKey(dataSourceName)) {
            return dynamicDataSource.getDataSources().get(dataSourceName);
        } else {
            return super.determineTargetDataSource();
        }
    }
}
