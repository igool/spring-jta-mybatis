package com.amos.spring.dschange.mapper;

import com.amos.spring.dschange.bean.Shop;

import java.util.List;


public interface ShopMapper extends SqlMapper {

    public List<Shop> findAllShop();
    
    public List<Shop> findAllShop2();
    
    public void updateShop();
    
    public void updateShop2();
    
    public void updateShopFail();
    
    

}
