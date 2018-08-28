package com.feng.baby.application.command;

import lombok.Data;
import lombok.NonNull;

@Data
public class UserAddressAddOrUpdate {

    private String userAddressId;

    private String provinceCode;
    private String cityCode;
    private String areaCode;

    private String province;
    private String city;
    private String area;

    @NonNull
    private String linkMan;
    private String address;
    @NonNull
    private String mobile;
    private String postalCode;
    private Boolean isDefault;
    //身份证号
    private String idcard;

    private String username;
}
