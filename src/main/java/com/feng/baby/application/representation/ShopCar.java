package com.feng.baby.application.representation;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ShopCar {

    private String shoppingCartId;
    private LocalDate createdAt;
    private String goodsId;
    private String username;
    private String propertyChildIds;
    private Integer buyNumber;

    private String pic;
    private String name;
    private String label;
    private Double price;


//    private String left = "";
//    private Boolean active = false;
}
