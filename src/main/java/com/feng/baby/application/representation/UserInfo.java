package com.feng.baby.application.representation;

import lombok.Data;

@Data
public class UserInfo {
    private String cellphone;
    private String wechatOpenId;
    private String country;
    private String province;
    private String city;
    private String gender;
    private String avatarUrl;
    private String nickName;
}
