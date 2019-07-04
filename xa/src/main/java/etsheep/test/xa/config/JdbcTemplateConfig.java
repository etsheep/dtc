package etsheep.test.xa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by etsheep on 2019-7-2.
 */

@Configuration
public class JdbcTemplateConfig {


    @Bean
    public JdbcTemplate ordersJdbcTemplate(DataSource ordersDataSource){
        return new JdbcTemplate(ordersDataSource);
    }

    @Bean
    public JdbcTemplate goodsJdbcTemplate(DataSource goodsDataSource){
        return new JdbcTemplate(goodsDataSource);
    }
}
