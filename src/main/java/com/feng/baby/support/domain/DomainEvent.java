package com.feng.baby.support.domain;

import lombok.Data;

@Data
public abstract class DomainEvent {

    private int version = 1;

}
