package com.feng.baby.application.representation;

import lombok.Data;

@Data
public class PintuanInfo {
    private String goodsId;
    private Integer numberRequire;
    private Integer numberSucccess;
    private Integer timeoutHours;
}
