package com.feng.baby.application.representation;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class CutDownInfo {

    private String cutDownId;

    private String initiator;
    private String nickName;
    private String avatarUrl;

    private Double currentPrice;
    private Double cutTotalAmount;
    private Double originalPrice;
    private Double basePrice;
    private Integer helperNumber;

    private String goodsId;
    private String goodsPic;
    private String goodsName;

    private LocalDateTime createdAt;
    private LocalDateTime expiryTimeAt;

    private boolean finished;

    private Long leftSecond;
}
