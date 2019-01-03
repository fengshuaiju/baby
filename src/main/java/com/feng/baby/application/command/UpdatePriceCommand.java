package com.feng.baby.application.command;

import lombok.Data;

@Data
public class UpdatePriceCommand {
    private Integer priceId;
    private Double price;
}
