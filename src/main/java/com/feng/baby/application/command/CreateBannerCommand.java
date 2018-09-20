package com.feng.baby.application.command;

import com.feng.baby.model.SlideContainerType;
import lombok.Data;

@Data
public class CreateBannerCommand {

    private String goodsId;
    private String picUrl;
    private Integer index;
    private SlideContainerType type;

}