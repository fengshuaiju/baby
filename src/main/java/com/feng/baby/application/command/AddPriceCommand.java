package com.feng.baby.application.command;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class AddPriceCommand {

    private List<Price> prices;

    @Data
    public class Price{
        private String propertiesJoint;
        private String goodsLabel;
        //type,price
        Map<String, Double> price;
    }

}
