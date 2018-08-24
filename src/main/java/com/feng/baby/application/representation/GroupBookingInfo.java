package com.feng.baby.application.representation;

import lombok.Data;

@Data
public class GroupBookingInfo {
    private String goodsId;
    private Integer numberRequire;
    private Integer numberSuccess;
    private Integer timeoutHours;
}
