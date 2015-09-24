package com.amos.spring.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created with IntelliJ IDEA.
 * User: vic
 * Date: 13-5-18
 * Time: 下午4:35
 * 将数据源的键存入ThreadLocal中
 */
public class DataSourceKeyHolder {
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();
    private static Logger logger = LoggerFactory.getLogger(DataSourceKeyHolder.class);

    public static void setDataSourceKey(String dataSourceKey) {
        contextHolder.set(dataSourceKey);
    }

    public static String getDataSourceKey() {
        String key = contextHolder.get();
        logger.info("Thread:"+Thread.currentThread().getName()+"dataSource key is "+ key);
        return key;
    }

    public static void clearDataSourceKey() {
        contextHolder.remove();
    }
}
