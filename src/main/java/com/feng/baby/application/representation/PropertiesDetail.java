package com.feng.baby.application.representation;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PropertiesDetail {
    private Integer id;
    private String detailId;
    private String propertiesId;
    private Integer indexs;
    private String name;
    private String remark;
}
