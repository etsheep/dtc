package etsheep.test.xa.service;

/**
 * Created by etsheep on 2019-7-3.
 */
public interface OrdersService {

    void order(int goodsId, int stock) throws Exception;
}
