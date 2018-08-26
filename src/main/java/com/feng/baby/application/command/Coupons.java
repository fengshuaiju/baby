package com.feng.baby.application.command;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
@Builder
@ToString
public class Coupons {

    private String couponId;
    private String picUrl;
    private String linkUrl;
    private Enum CouponsType;
    private String couponName;
    private Double amountOfMoney;
    private Double requirementConsumption;

    private LocalDate expiryTimeAt;
    private String remarks;

    private Boolean available;

}
