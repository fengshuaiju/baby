package com.feng.baby.application.representation;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GoodsInfo {

    private BasicInfo basicInfo;

    private List<Properties> properties;

    private List<GoodsMedia> pics;

}
