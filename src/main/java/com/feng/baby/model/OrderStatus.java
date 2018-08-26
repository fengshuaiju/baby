package com.feng.baby.model;

public enum  OrderStatus {

    INIT, //创建完订单，待付款
    PAID, //订单已支付
    PENDING_DELIVERY, //待发货
    TO_BE_RECEIVED, //待收货
    TO_BE_JUDGE //待评价

}
