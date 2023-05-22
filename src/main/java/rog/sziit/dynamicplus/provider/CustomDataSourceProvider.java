package rog.sziit.dynamicplus.provider;

import org.springframework.stereotype.Component;
import rog.sziit.dynamicplus.utils.DynamicDataSourceContextHolder;


/**
 * @author:poboking
 * @version:1.0
 * @time:2023/5/22 11:24
 */
@Component
public class CustomDataSourceProvider implements DataSourceProvider{
    @Override
    public  String getDataSourceName() {
        // 根据具体业务需求获取需要使用的数据源名称
        return DynamicDataSourceContextHolder.getDataSource();
    }

}