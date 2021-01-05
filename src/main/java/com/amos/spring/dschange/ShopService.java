package com.amos.spring.dschange;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amos.spring.annotation.ChooseDataSource;
import com.amos.spring.dschange.bean.Shop;
import com.amos.spring.dschange.mapper.ShopMapper;

@Service
public class ShopService {


//    @Resource
    @Autowired
    private ShopMapper shopMapper;

    @ChooseDataSource("ds_1")
    public List<Shop> findAllShop() {
        return shopMapper.findAllShop();
    }
    
    @ChooseDataSource("ds_2")
    public List<Shop> findAllShop2() {
        return shopMapper.findAllShop2();
    }
    
    @ChooseDataSource("ds_1")
    public void updateShop(){
    	shopMapper.updateShop();
    }
    
    @ChooseDataSource("ds_2")
    public void updateShop2(){
    	shopMapper.updateShop2();
    }
    
    @ChooseDataSource("ds_2")
    public void updateShopFail(){
    	shopMapper.updateShopFail();
    }
    
    @Transactional
    public void updateJta(){
    	updateShop();
    	updateShop2();
    }
    
    @Transactional
    public void updateJtaFail(){
    	updateShop();
    	updateShopFail();
    }
}
