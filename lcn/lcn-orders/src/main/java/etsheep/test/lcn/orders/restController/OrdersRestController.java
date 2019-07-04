package etsheep.test.lcn.orders.restController;

import etsheep.test.lcn.orders.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by etsheep on 2019-7-3.
 */

@RestController
@RequestMapping("/api/orders")
public class OrdersRestController {


    @Autowired
    private OrdersService ordersService;

    @GetMapping("/order")
    public void order(int goodsId, int stock) throws Exception {
        ordersService.order(goodsId, stock);
    }
}
