package etsheep.test.xa.service.impl;

import etsheep.test.xa.service.GoodsService;
import etsheep.test.xa.service.model.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by etsheep on 2019-7-3.
 */

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    @Qualifier("goodsJdbcTemplate")
    private JdbcTemplate goodsJdbcTemplate;

    @Override
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
