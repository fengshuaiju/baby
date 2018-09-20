package com.feng.baby.application.command;

import com.feng.baby.model.CouponsType;
import lombok.Data;
import lombok.NonNull;

@Data
public class AddNewCouponCommand {

    @NonNull
    private String picUrl;

    @NonNull
    private String linkUrl;

    @NonNull
    private String couponName;

    private CouponsType type;//新人红包、折扣红包

    @NonNull
    private Double amountOfMoney;
    @NonNull
    private Double requirementConsumption;

    @NonNull
    private Integer validityDay;
    private String remarks;

}
