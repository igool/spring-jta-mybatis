package com.amos.spring.datasource;

import com.amos.spring.util.DataSourceKeyHolder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;


public class CustomerDatasource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceKeyHolder.getDataSourceKey();
    }
}
