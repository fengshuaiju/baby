package com.feng.baby.model;

public enum  SlideContainerType {
    HOME("主页"),
    MENU("类型页");

    private String type;
    SlideContainerType(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }
}
