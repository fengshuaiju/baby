package com.feng.baby.application.representation;

import lombok.Data;

@Data
public class GoodsPriceInfo {

    private Double originalMinPrice;
    private String originalPriceRange;

    private Double cutDownMinPrice;
    private String cutDownPriceRange;

    private Double groupMinPrice;
    private String groupPriceRange;

}
