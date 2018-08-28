package com.feng.baby.application.command;

import lombok.Data;

@Data
public class CreateCutDown {
    private String goodsId;
    private String username;
    private Integer buyNumber;
    private String propertyChildIds;
    private String goodsLabel;
}
