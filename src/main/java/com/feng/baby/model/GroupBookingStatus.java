package com.feng.baby.model;

public enum GroupBookingStatus {
    INIT,
    WAITING_GROUP, //发起人付过款
    IN_PROGRESS, //等待第二个人付款
    FINISHED //两人付款结束
}
