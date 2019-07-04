package etsheep.test.xa.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by etsheep on 2019-7-2.
 */
@Configuration
@ConditionalOnMissingClass("com.alibaba.druid.pool.xa.DruidXADataSource")
public class DataSourceConfig {

    @Bean("ordersDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.orders")
    public DataSource ordersDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean("goodsDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.goods")
    public DataSource goodsDataSource(){
        return DataSourceBuilder.create().build();
    }

//    @Primary
    @Bean("ordersTransactionManager")
    public DataSourceTransactionManager ordersTransactionManager(DataSource ordersDataSource) {
        return new DataSourceTransactionManager(ordersDataSource);
    }

    @Bean("goodsTransactionManager")
    public DataSourceTransactionManager goodsTransactionManager(DataSource goodsDataSource) {
        return new DataSourceTransactionManager(goodsDataSource);
    }
}
