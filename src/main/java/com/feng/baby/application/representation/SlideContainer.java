package com.feng.baby.application.representation;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SlideContainer {
    private String id;
    private String goodsId;
    private String picUrl;
    private Integer orders;
}
