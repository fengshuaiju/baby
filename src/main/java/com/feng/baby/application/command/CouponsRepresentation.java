package com.feng.baby.application.command;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
@Builder
@ToString
public class CouponsRepresentation {

    private String couponId;
    private String picUrl;
    private String linkUrl;
    private Enum CouponsType;
    private String couponName;
    private Double amountOfMoney;
    private Double requirementConsumption;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate periodOfValidityToAt;
    private String remarks;

    private Boolean available;


    public String getPeriodOfValidityToAt() {
        return this.periodOfValidityToAt.toString();
    }

}
