package com.feng.baby.application.command;

import com.feng.baby.model.CouponsType;
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
    private CouponsType type;
    private String couponName;
    private Double amountOfMoney;
    private Double requirementConsumption;

    private LocalDate expiryTimeAt;
    private String remarks;

    private Boolean isAvailable;

}
