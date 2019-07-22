package etsheep.test.lcn.orders;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.rpc.Filter;
import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import java.sql.DriverManager;

/**
 * Created by etsheep on 2019-7-4.
 */

@SpringBootApplication
@EnableDistributedTransaction
@ImportResource({"classpath:dubbo/dubboConfiguration.xml"})
public class LcnOrdersApplication {

    public static void main(String[] args){
        SpringApplication.run(LcnOrdersApplication.class, args);
    }
}
