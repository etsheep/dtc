package etsheep.test.lcn.orders.test.dubbo;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;

/**
 * Created by etsheep on 2019-7-7.
 */
public class testMain {

    public static void main(String[] args) {
        URL url = URL.valueOf("test://localhost/test?aaa=zookeeper1")
                .addParameter("service", "helloService");
        Registry registry = ExtensionLoader.getExtensionLoader(Registry.class)
                .getAdaptiveExtension();
//        ExtensionLoader.getExtensionLoader(Registry.class).get
        String register = registry.register(url, "maple");

        System.out.println(register);
    }
}
