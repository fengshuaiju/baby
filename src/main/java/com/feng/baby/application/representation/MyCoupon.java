package com.feng.baby.application.representation;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MyCoupon {

    private LocalDateTime createdAt;
    private String couponId;
    private String picUrl;
    private String linkUrl;
    private String couponName;
    private String type;
    private Double amountOfMoney;
    private Double requirementConsumption;
    private LocalDateTime expiryTimeAt;
    private String remarks;
    private Boolean available;

}
