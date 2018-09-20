package com.feng.baby.application.command;

import lombok.Data;

@Data
public class AddGroupCommand {

    private String goodsId;
    private Integer numberRequire;
    private Integer timeoutHours;

}
