package com.feng.baby.application.representation;

import lombok.Data;

@Data
public class CmsRepresentation {

    private String cmsId;
    private Integer indexs;
    private String author;
    private String pic;
    private String title;
    private String describe;
    private String content;
    private boolean isRecommend;
    private Integer commentNumber;
    private Integer categoryId;
    private Double minPrice;
    private Integer views;

    private String type;
}
