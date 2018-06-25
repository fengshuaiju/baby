package com.feng.baby.application.representation;

import lombok.Builder;
import lombok.Data;

/**
 * Created by fengshuaiju on 2018-06-03.
 */
@Data
@Builder
public class OrderRepresentation {

    private String orderId;
    private String customerName;
    private String customerSex;
    private String customerPhone;

}
