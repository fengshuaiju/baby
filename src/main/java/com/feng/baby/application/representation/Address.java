package com.feng.baby.application.representation;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Address {

    private String userAddressId;
    private LocalDateTime createdAt;
    private String username;
    private String province;
    private String provinceCode;
    private String city;
    private String cityCode;
    private String area;
    private String areaCode;
    private String address;
    private Boolean isDefault;
    private String linkMan;
    private String mobile;
    private Boolean status;

    private String postalCode;
}
