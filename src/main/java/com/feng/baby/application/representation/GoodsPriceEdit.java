package com.feng.baby.application.representation;

import com.feng.baby.model.PriceType;
import lombok.Data;

@Data
public class GoodsPriceEdit {

    private String priceId;
    private String goodsId;
    private String propertyName;
    private String propertyId;
    private double price;
    private PriceType priceType;
    private String priceTypeValue;

    public String getPriceTypeValue(){
        return priceType == null ? "" : priceType.getName();
    }

    public GoodsPriceEdit(String goodsId, String propertyId, String propertyName){
        this.goodsId = goodsId;
        this.propertyId = propertyId;
        this.propertyName = propertyName;
    }

    public GoodsPriceEdit(String goodsId, String propertyId, String propertyName, PriceType priceType){
        this.goodsId = goodsId;
        this.propertyId = propertyId;
        this.propertyName = propertyName;
        this.priceType = priceType;
    }

}
