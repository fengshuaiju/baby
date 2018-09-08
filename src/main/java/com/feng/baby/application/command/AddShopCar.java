package com.feng.baby.application.command;

import lombok.Data;

@Data
public class AddShopCar {

    private String shoppingCartId;
    private String goodsId;
    private String propertyChildIds;
    private Integer buyNumber;
    private String username;

}
