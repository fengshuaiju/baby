package com.feng.baby.application.service;


import com.feng.baby.application.command.CreateOrderGoodsInfo;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class OrderService {

    private final DSLContext jooq;

    @Autowired
    OrderService(DSLContext jooq) {
        this.jooq = jooq;
    }


    public void createOrder(String username, List<CreateOrderGoodsInfo> goodsInfos, String addressId, String couponId, String remark) {
        //查找商品

        //查找红包，获取红包金额，减去红包金额

        //获取寄送地址，填入寄送地址

        //如果订单是拼团类型，更改拼团类型 INIT > WAITING_GROUP

    }
}
