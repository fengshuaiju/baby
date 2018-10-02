package com.feng.baby.application.command;

import lombok.Data;

@Data
public class AddCmsCommand {

    private String indexs;
    private String author;
    private String pic;
    private String title;
    private String describe;
    private String content;
    private boolean isRecommend;
    private String categoryId;
    private String minPrice;

}
