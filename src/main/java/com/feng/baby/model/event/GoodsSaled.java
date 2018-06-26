package com.feng.baby.model.event;

import com.feng.baby.support.domain.DomainEvent;
import lombok.Builder;
import lombok.Data;

/**
 * Created by fengshuaiju on 2018-06-26.
 */
@Data
@Builder
public class GoodsSaled extends DomainEvent{

    private String name;
    private String code;

}
