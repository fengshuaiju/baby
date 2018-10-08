package com.feng.baby.application.command;

import lombok.Data;

import java.util.List;

@Data
public class CreateGoodsCommand {

    private String categoryId;
    private String name;
    private String characteristic;
    private String imagePath;
    private Boolean isSupportGroup;
    private Boolean isSupportCutDown;
    private String remark;

    private String content;

    private List<GoodsProperties> properties;

    @Data
    public static class GoodsProperties{
        private Integer index;
        private String name;
        private String[] label;

        public GoodsProperties(String name, String[] label){
            this.index = 1;
            this.name = name;
            this.label = label;
        }
    }

}