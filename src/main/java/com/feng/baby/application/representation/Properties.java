package com.feng.baby.application.representation;

import lombok.Builder;
import lombok.Data;
import sprout.jooq.generate.tables.records.PropertiesRecord;

import java.util.List;

@Data
@Builder
public class Properties {

    private Integer id;
    private String propertiesId;
    private Integer indexs;
    private String name;
    private List<PropertiesDetail> childsCurGoods;

    public static Properties toProperties(PropertiesRecord record){
        return Properties.builder()
                .id(record.getId())
                .propertiesId(record.getPropertiesId())
                .name(record.getName())
                .indexs(record.getIndexs())
                .build();
    }

}
