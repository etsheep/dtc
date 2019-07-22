package etsheep.test.lcn.goods.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import etsheep.test.lcn.goods.model.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by etsheep on 2019-7-3.
 */

@Component("goodsService")
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private JdbcTemplate goodsJdbcTemplate;

    @Override
    @LcnTransaction
    @Transactional
    public void reduceStock(int goodsId, int reduceStock){
        Goods goods = goodsJdbcTemplate.queryForObject("SELECT * FROM GOODS WHERE ID = ?", new BeanPropertyRowMapper<>(Goods.class), goodsId);
        if (goods != null){
            if (reduceStock > goods.getStock()){
                throw new RuntimeException("库存不够了！！！！!");
            }else{
                goodsJdbcTemplate.update("UPDATE GOODS SET STOCK = STOCK - ? WHERE ID = ?", reduceStock, goodsId);
            }
        }
    }
}
