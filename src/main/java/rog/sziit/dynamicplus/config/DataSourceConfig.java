package rog.sziit.dynamicplus.config;

import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import rog.sziit.dynamicplus.models.DataSourceEntity;

import javax.sql.DataSource;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author:poboking
 * @version:1.0
 * @time:2023/5/21 20:03
 */

@Configuration
public class DataSourceConfig {


    @Bean(name = "mysqlDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.dynamic.datasource.slave")
    public DataSource mysqlHikariDataSource(DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder()
                .type(HikariDataSource.class)
                .build();
    }

    @Bean(name = "saveDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.dynamic.datasource.master")
    public DataSource saveHikariDataSource(DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder()
                .type(HikariDataSource.class)
                .build();
    }

    /**
     * 使用默认HikariCP配置的HikariDaSource生成器
     *
     * @param dataSourceProperties
     * @return
     */
    @Bean(name = "baseDataSource")
    @Scope("prototype")
    @ConfigurationProperties(prefix = "hikari")
    public HikariDataSource baseHikariDataSource(DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder()
                .type(HikariDataSource.class)
                .build();
    }

    /**
     * 生成MP框架内置的DynamicDataSource类
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    public DynamicRoutingDataSource dynamicDataSource() {
        return new DynamicRoutingDataSource();
    }

    /**
     * 生成用于存储DataSourceEntity的map
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    public Map<String, DataSourceEntity> dataSourceEntityMap() {
        return new ConcurrentHashMap<>();
    }
}
