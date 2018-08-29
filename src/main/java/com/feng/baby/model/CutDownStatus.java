package com.feng.baby.model;

public enum  CutDownStatus {
    INIT,
    IN_PROGRESS,
    SUCCESS,//砍价完成 时间过期后 由程序检测，变为Success
    CANCEL,//选错商品，不想要了，可以取消
    FINISH
}
