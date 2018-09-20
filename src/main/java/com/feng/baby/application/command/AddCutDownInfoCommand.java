package com.feng.baby.application.command;

import lombok.Data;
import lombok.NonNull;

@Data
public class AddCutDownInfoCommand {

    @NonNull
    private String goodsId;
    @NonNull
    private Double maxAmountPerCut;
    @NonNull
    private Double minAmountPerCut;
    @NonNull
    private Integer effectiveTime;
    @NonNull
    private Double maxCutDown;
    @NonNull
    private Integer maxHelper;

}
