package com.feng.baby.application.representation;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserInfo {
    private String cellphone;
    private String wechatOpenId;
    private LocalDateTime createdAt;
    private String country;
    private String province;
    private String city;
    private String gender;
    private String avatarUrl;
    private String nickName;

    public UserInfo updateGender() {
        this.setGender(this.gender == null ? "无性别" :
                this.gender.equals("1") ? "男" : "女");
        return this;
    }
}
