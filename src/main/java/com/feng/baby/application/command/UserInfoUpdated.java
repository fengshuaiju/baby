package com.feng.baby.application.command;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserInfoUpdated {

    private String username;

    private String country;
    private int gender;
    private String province;
    private String city;
    private String avatarUrl;
    private String nickName;
    private String language;

}
