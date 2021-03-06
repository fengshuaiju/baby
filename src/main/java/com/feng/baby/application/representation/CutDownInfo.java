package com.feng.baby.application.representation;

import com.feng.baby.model.CutDownStatus;
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
    private Integer buyNumber;

    private String goodsId;
    private String goodsPic;
    private String goodsName;

    private String goodsLabel;
    private String propertiesJoint;

    private LocalDateTime createdAt;
    private LocalDateTime expiryTimeAt;

    private String status;
    private String statusDesc;

    private Long leftSecond;

    public CutDownInfo setDesc(String status){
        this.statusDesc = CutDownStatus.valueOf(status).getDesc();
        return this;
    }
}
