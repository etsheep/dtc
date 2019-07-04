package etsheep.test.xa.service.impl;

import etsheep.test.xa.service.GoodsService;
import etsheep.test.xa.service.OrdersService;
import etsheep.test.xa.utils.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by etsheep on 2019-7-3.
 */

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    @Qualifier("ordersJdbcTemplate")
    private JdbcTemplate ordersJdbcTemplate;
    @Autowired
    private GoodsService goodsService;

    private static final long dataCenterId = 11;
    private static final long machineId = 3;

    @Override
    @Transactional
    public void order(int goodsId, int stock) {
        SnowFlake snowFlake = new SnowFlake(dataCenterId, machineId);
        String orderNo = String.valueOf(snowFlake.nextId());
        ordersJdbcTemplate.update("INSERT INTO ORDERS(orderNo, money, createDatetime, orderDetail) VALUES(?,?,?,?)", orderNo, 20, new Date(), goodsId + "*" + stock);
        goodsService.reduceStock(goodsId, stock);
        throw new RuntimeException("aaaaaaaaaa");
    }
}
