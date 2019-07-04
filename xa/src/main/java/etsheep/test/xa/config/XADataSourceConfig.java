package etsheep.test.xa.config;

import com.alibaba.druid.pool.xa.DruidXADataSource;
import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import com.atomikos.jdbc.AtomikosDataSourceBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.sql.DataSource;
import javax.transaction.UserTransaction;

/**
 * Created by etsheep on 2019-7-3.
 */
@Configuration
@ConditionalOnClass(DruidXADataSource.class)
public class XADataSourceConfig {

    @Bean("ordersDataSource")
    public DataSource ordersDataSource(){
        DruidXADataSource druidXADataSource = new DruidXADataSource();
        druidXADataSource.setUrl("jdbc:mysql://127.0.0.1:3306/orders?useSSL=true");
        druidXADataSource.setUsername("root");
        druidXADataSource.setPassword("123456");
        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(druidXADataSource);
        atomikosDataSourceBean.setUniqueResourceName("ordersDataSource");
        atomikosDataSourceBean.setPoolSize(5);
        return atomikosDataSourceBean;
    }


    @Bean("goodsDataSource")
    public DataSource goodsDataSource(){
        DruidXADataSource druidXADataSource = new DruidXADataSource();
        druidXADataSource.setUrl("jdbc:mysql://127.0.0.1:3306/goods?useSSL=true");
        druidXADataSource.setUsername("root");
        druidXADataSource.setPassword("123456");
        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(druidXADataSource);
        atomikosDataSourceBean.setUniqueResourceName("goodsDataSource");
        atomikosDataSourceBean.setPoolSize(5);
        return atomikosDataSourceBean;
    }


    @Bean(name = "transactionManager")
    @Primary
    public JtaTransactionManager transactionManager () {
        UserTransactionManager userTransactionManager = new UserTransactionManager();
        UserTransaction userTransaction = new UserTransactionImp();
        return new JtaTransactionManager(userTransaction, userTransactionManager);
    }

}
