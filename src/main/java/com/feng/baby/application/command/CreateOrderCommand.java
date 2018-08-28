package com.feng.baby.application.command;

import com.feng.baby.model.OrderType;
import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

/**
 * Created by fengshuaiju on 2018-06-30.
 */
@Data
@ToString
public class CreateOrderCommand {

    private String username;
    //购买的商品、规格尺寸、数量信息的数组 -> CreateOrderGoodsInfo
    @NonNull
    private String goodsJsonStr;

    private String couponId;
    private String remark;
    private String addressId;

    private OrderType orderType;

    private String cutDownId;
    private String groupBookingId;
}
