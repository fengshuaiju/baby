package com.feng.baby.application.command;

import lombok.Data;

@Data
public class CreateOrderGoodsInfo {

    private String goodsId;
    private Integer number;
    private String propertyChildIds;
    private String inviterId;
    private String groupBookingId;
    private String cutDownId;

}
