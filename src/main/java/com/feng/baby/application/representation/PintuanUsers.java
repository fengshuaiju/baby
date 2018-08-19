package com.feng.baby.application.representation;

import lombok.Data;

@Data
public class PintuanUsers {
    private String goodsId;
    private String username;
    private Integer numberRequire;
    private Integer numberLeft;
    private Boolean finished;
    private String nick;
    private String avatarUrl;
}
