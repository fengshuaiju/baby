package com.feng.baby.application.command;

import lombok.Data;

import java.util.List;

@Data
public class CreateGoodsCommand {

    private String categoryId;
    private String name;
    private String characteristic;
    private String mainPic;
    private boolean isSupportGroup;
    private String content;

    private List<GoodsProperties> properties;

    @Data
    public class GoodsProperties{
        private Integer index;
        private String name;
        private List<PropertiesDetail> details;
    }

    @Data
    public class PropertiesDetail{
        private Integer index;
        private String name;
        private String remarks;
    }

}