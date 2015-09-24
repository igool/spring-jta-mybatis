package com.amos.spring.dschange;

import com.amos.spring.dschange.bean.Shop;
import com.amos.spring.annotation.ChooseDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * User:Amos.zhou
 * Date: 14-3-14
 * Time: 下午5:59
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext.xml")
//@ChooseDataSource("ds_1")
public class TestChangeDs {

    @Autowired
    private ShopService shopService;

    @Test
    @Rollback(false)
   // @ChooseDataSource("ds_1")
    public void testFindAllShop(){
        List<Shop> shopList1 = shopService.findAllShop();
        System.out.println(shopList1);

       // fromTestDB();
        System.out.println("######");
    }
    @Test
  // @ChooseDataSource("ds_2")
    public void fromTestDB(){
        List<Shop> shopList = shopService.findAllShop2();
      
        System.out.println(shopList);
        System.out.println("$$$$$$");
    }
    
    @Test
    public void testJTA(){
    	shopService.updateJta();
    	System.out.println("SUCCESS JTA");
    }

    // @Test
    public void testJTAFail(){
    	shopService.updateJtaFail();
    	System.out.println("Fail JTA");
    }
}
