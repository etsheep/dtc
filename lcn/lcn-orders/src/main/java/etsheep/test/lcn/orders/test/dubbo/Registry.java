package etsheep.test.lcn.orders.test.dubbo;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.SPI;

@SPI("zookeeper")
public interface Registry {
    /**
     * 注册服务
     */
    @Adaptive(value = "aaa")
    String register(URL url, String content);
    /**
     * 发现服务
     */
    @Adaptive()
    String discovery(URL url, String content);
}