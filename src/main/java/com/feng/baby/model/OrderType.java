package com.feng.baby.model;

public enum OrderType {
    GROUP_BOOKING("GROUP"),
    CUT_DOWN("CUT_DOWN"),
    NORMAL("CHEAP"),
    SHOPPING_CART("CHEAP");

    private String priceType;

    OrderType(String priceType){
        this.priceType = priceType;
    }

    public String getPriceType(){
        return this.priceType;
    }
}
