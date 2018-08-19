package com.feng.baby.application.representation;

import lombok.Data;

@Data
public class Category {
    private Integer id;
    private Integer level;
    private String name;
    private Integer pid;
    private Boolean isUse;
    private String icon;
    private Integer indexs;
}
