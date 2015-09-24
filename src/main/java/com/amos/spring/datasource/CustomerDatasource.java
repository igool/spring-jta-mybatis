package com.amos.spring.datasource;

import com.amos.spring.util.DataSourceKeyHolder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * User:Amos.zhou
 * Date: 14-3-14
 * Time: 下午5:27
 */
public class CustomerDatasource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceKeyHolder.getDataSourceKey();
    }
}
