package rog.sziit.dynamicplus.utils;

/**
 * @author:poboking
 * @version:1.0
 * @time:2023/5/21 19:31
 */

public class DynamicDataSourceContextHolder {
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public static void setDataSource(String dataSourceName) {
        contextHolder.set(dataSourceName);
    }

    public static String getDataSource() {
        return contextHolder.get();
    }

    public static void clearDataSource() {
        contextHolder.remove();
    }
}