package com.feng.baby.model;

import lombok.Data;

import java.util.List;

@Data
public class GoodsProperties {


    private Integer id;//属性ID
    private Integer index;//排序
    private String name;//电视机尺寸

    private List<ChildsCurGood> childsCurGoods;


    @Data
    private class ChildsCurGood {
        private Integer propertyId;
        private Integer index;//排序
        private String name;//红色。蓝色
        private String remark;
    }
}
