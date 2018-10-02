package com.feng.baby.application.command;

import lombok.Data;
import lombok.NonNull;

@Data
public class AddCategoryCommand {

    @NonNull
    private Integer level;
    @NonNull
    private String name;
    @NonNull
    private String pid;
    @NonNull
    private String icon;
    @NonNull
    private Integer indexs;

}
