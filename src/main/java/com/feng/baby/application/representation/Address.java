package com.feng.baby.application.representation;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Address {

    private String userAddressId;
    private LocalDateTime createdAt;
    private String username;
    private String province;
    private String city;
    private String area;
    private String address;
    private Boolean isDefault;
    private String linkMan;
    private String mobile;
    private Boolean status;

}
