package com.feng.baby.application.representation;

import com.feng.baby.model.SlideContainerType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SlideContainer {
    private String id;
    private String goodsId;
    private String picUrl;
    private Integer orders;
    private SlideContainerType type;
    private String goodsName;

    public String getType(){
        return type.getType();
    }
}
