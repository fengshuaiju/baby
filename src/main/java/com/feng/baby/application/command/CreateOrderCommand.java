package com.feng.baby.application.command;

import lombok.Data;

/**
 * Created by fengshuaiju on 2018-06-30.
 */
@Data
public class CreateOrderCommand {

    private int provinceId;//		收货地址省份编码	X
    private int cityId;//	收货地址城市编码	X
    private int districtId;//		收货地址区县编码	X
    private String address;//		收货地址详细地址	X
    private String linkMan;//		收货地址联系人信息	X
    private String mobile;//		收货地址联系人手机号码	X
    private String code;//		收货地址邮政编码	X
    private String remark;//		下单备注信息	X
    private int couponId;//		使用的优惠券编号	X
    private Boolean calculate;//		true 不实际下单，而是返回价格计算	X
    private String idcard;//		身份证号码【国际件使用】	X
    private String goodsJsonStr;//		购买的商品、规格尺寸、数量信息的数组，如：[{"goodsId":11,"number":2,"propertyChildIds":"","logisticsType":0}, {"goodsId":8,"number":3,"propertyChildIds":"2:9","logisticsType":0, "inviter_id":邀请用户ID}]	Y
    private int payOnDelivery;//		1 为货到付款，其他数字为先支付	X
    private int expireMinutes;//		多少分钟未支付自动关闭本订单，传0不自动关闭订单	X
    private int kjid;//		砍价编号，可直接购买砍价商品	X
    private int pingtuanOpenId;//		拼团购买的团号	X
    private Boolean isCanHx;//		是否支持核销，true 支持，默认不支持	X

}
