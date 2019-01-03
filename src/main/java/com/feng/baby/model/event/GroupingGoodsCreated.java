package com.feng.baby.model.event;

import com.feng.baby.support.domain.DomainEvent;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GroupingGoodsCreated extends DomainEvent{

    private String goodsId;

}
