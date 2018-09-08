package com.feng.baby.application.command;

import lombok.Data;

@Data
public class ShopCarUpdate {
    private String username;
    private String shoppingCartId;
    private Integer buyNumber;
}
