package com.feng.baby.application.representation;

import lombok.Data;

@Data
public class BasicInfo {

    private Integer id;
    private String goodsId;
    private Integer categoryId;
    private String name;
    private String characteristic;
    private String mainPic;

    private boolean status;
    private boolean pingtuan;
    private String content;
    private Integer views;
    private Integer numberFav;
    private Integer numberReputation;
    private Integer stores;
    private Integer numberOrders;
    private String remark;


    //价格制定

    //原价
    private Double originalPrice;
    //最低价,供砍价使用
    private Double minPrice;
    //拼团起步价，不同型号的商品中，给出最低的价格
    private Double pingtuanPrice;
    //优惠价
    private Double concessionalPrice;
}
