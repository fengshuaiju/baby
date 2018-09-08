package com.feng.baby.application.representation;

import lombok.Data;

@Data
public class Category {
    private String categoryId;
    private Integer level;
    private String name;
    private String pid;
    private Boolean isUse;
    private String icon;
    private Integer indexs;
}
