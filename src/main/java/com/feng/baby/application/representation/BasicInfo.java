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
    private Double originalPrice;
    private Double minPrice;
    private Double pingtuanPrice;
    private boolean status;
    private boolean pingtuan;
    private String content;
    private Integer views;
    private Integer numberFav;
    private Integer numberReputation;
    private Integer stores;
    private Integer numberOrders;
    private String remark;
}
