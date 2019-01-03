package com.feng.baby.application.command;

import lombok.Data;

@Data
public class AddSlideContainerCommand {

    private String picUrl;
    private String goodsId;
    private String slideType;

}
