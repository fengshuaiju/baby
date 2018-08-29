package com.feng.baby.application.command;

import lombok.Data;
import lombok.NonNull;

@Data
public class CreateOrderGoodsInfo {
    @NonNull
    private String goodsId;
    private Integer buyNumber;
    private String propertyChildIds;
    private String goodsLabel;
    private String inviterId;
    private String groupBookingId;
    private String cutDownId;
}
