package com.feng.baby.application.representation;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SlideContainer {

    private String id;
    private String linkUrl;
    private String order;
    private String picUrl;
    private String paixu;
    private String businessId;
    private String remark;
    private String status;
    private String statusStr;

}
