package com.feng.baby.application.representation;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GoodsFav {

    private String goodsId;
    private String name;
    private String username;
    private LocalDateTime addTime;
    private String goodsPic;

}
