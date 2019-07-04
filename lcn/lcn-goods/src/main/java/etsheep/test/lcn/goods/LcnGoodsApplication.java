package etsheep.test.lcn.goods;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by etsheep on 2019-7-4.
 */

@SpringBootApplication
@EnableDistributedTransaction
@ImportResource({"classpath:dubbo/dubboConfiguration.xml"})
public class LcnGoodsApplication {

    public static void main(String[] args){
        SpringApplication.run(LcnGoodsApplication.class, args);
    }
}
