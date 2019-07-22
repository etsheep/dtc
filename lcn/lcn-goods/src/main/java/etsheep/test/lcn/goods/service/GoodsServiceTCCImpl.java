//package etsheep.test.lcn.goods.service;
//
//import com.alibaba.dubbo.config.annotation.Service;
//import com.codingapi.txlcn.tc.annotation.LcnTransaction;
//import com.codingapi.txlcn.tc.annotation.TccTransaction;
//import etsheep.test.lcn.goods.model.Goods;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.io.ObjectInputStream;
//import java.util.concurrent.ConcurrentHashMap;
//
///**
// * Created by etsheep on 2019-7-5.
// */
//
//@Component
//@Service
//public class GoodsServiceTCCImpl implements GoodsService{
//
//
//    @Autowired
//    private JdbcTemplate goodsJdbcTemplate;
//
//    private ConcurrentHashMap<String, Long> ids = new ConcurrentHashMap<>();
//
//    @Override
//    @TccTransaction()
//    @Transactional
//    public void reduceStock(int goodsId, int reduceStock){
//        ObjectInputStream
//        Goods goods = goodsJdbcTemplate.queryForObject("SELECT * FROM GOODS WHERE ID = ?", new BeanPropertyRowMapper<>(Goods.class), goodsId);
//        if (goods != null){
//            if (reduceStock > goods.getStock() - ){
//                throw new RuntimeException("库存不够了！！！！!");
//            }else{
//                goodsJdbcTemplate.update("UPDATE GOODS SET STOCK = STOCK - ? WHERE ID = ?", reduceStock, goodsId);
//            }
//        }
//    }
//
//    public void reduceStockConfirm(int goodsId, int reduceStock){
//
//    }
//
//    public void reduceStockCancel(int goodsId, int reduceStock){
//
//    }
//}
