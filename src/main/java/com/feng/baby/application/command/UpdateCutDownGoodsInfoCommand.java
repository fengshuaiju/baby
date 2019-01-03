package com.feng.baby.application.command;

import lombok.Data;

@Data
public class UpdateCutDownGoodsInfoCommand {

    private String goodsId;
    private double maxAmountPerCut;
    private double minAmountPerCut;
    private int effectiveTime;
    private double maxCutDown;
    private int maxHelper;

}
