package com.feng.baby.application.representation;

import lombok.Data;

import java.util.Map;

@Data
public class BasicInfo {

    private Integer id;
    private String goodsId;
    private String categoryId;
    private String name;
    private String characteristic;
    private String mainPic;

    private boolean is_remove;
    private boolean is_support_pingtuan;
    private String content;
    private Integer views;
    private Integer numberFav;
    private Integer numberReputation;
    private Integer stores;
    private Integer numberOrders;
    private String remark;

//    {
//            "GROUP": 223.3,
//            "NORMAL_RANGE": "385.3-794.9",
//            "GROUP_RANGE": "223.3-667.9",
//            "CUT_DOWN": 311.3,
//            "CUT_DOWN_RANGE": "311.3-694.9",
//            "CHEAP": 337.3,
//            "NORMAL": 385.3,
//            "CHEAP_RANGE": "337.3-726.9"
//    }
    private Map<String, Object> price;

}
