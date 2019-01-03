package com.feng.baby.model;

public enum PriceType {
    GROUP("拼团价格"),
    CUT_DOWN("砍价价格"),
    NORMAL("普通价格"),
    CHEAP("优惠价");//优惠价

    private String name;

    PriceType(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
