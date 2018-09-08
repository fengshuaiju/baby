package com.feng.baby.model;

public enum  CutDownStatus {
    INIT("创建完成"),
    IN_PROGRESS("正在砍价"),
    SUCCESS("砍价完成"),//砍价完成 时间过期后 由程序检测，变为Success
    CANCEL("已取消"),//选错商品，不想要了，可以取消
    FINISH("已完成");

    private String desc;

    CutDownStatus(String desc){
        this.desc = desc;
    }

    public String getDesc(){
        return this.desc;
    }
}
