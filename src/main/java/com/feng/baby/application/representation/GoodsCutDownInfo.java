package com.feng.baby.application.representation;

import com.feng.baby.model.CutDownInfoStatus;
import lombok.Data;

@Data
public class GoodsCutDownInfo {

    private String goodsId;
    private String goodsName;
    private Double maxAmountPerCut;
    private Double minAmountPerCut;
    private Integer effectiveTime;
    private Double maxCutDown;
    private Integer maxHelper;
    private CutDownInfoStatus status;

}
