package com.feng.baby.application.representation;

import lombok.AllArgsConstructor;
import lombok.Data;
import sprout.jooq.generate.tables.records.GoodsRecord;

import java.util.List;

@Data
@AllArgsConstructor
public class GoodsInfo {

    private BasicInfo basicInfo;

    private List<Properties> properties;

    private List<GoodsMedia> pics;
}
