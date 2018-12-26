package com.feng.baby.application.command;

import lombok.Data;

@Data
public class GoodsPutOnOffCommand {
    private String goodsId;
    private Boolean status;
    private Boolean grouping;
}
