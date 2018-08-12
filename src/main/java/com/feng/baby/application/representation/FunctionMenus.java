package com.feng.baby.application.representation;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FunctionMenus {

    private String linkUrl;
    private String picUrl;
    private Integer orders;
    private String title;
    private boolean status;

}
