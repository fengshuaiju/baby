package com.feng.baby.application.representation;

import lombok.Data;

import java.time.Duration;
import java.time.LocalDateTime;

@Data
public class GroupBookingJoiner {

    private String groupBookingId;
    private String username;
    private Integer numberRequire;
    private Integer numberLeft;
    private Boolean finished;
    private String nickName;
    private String avatarUrl;

    private LocalDateTime expiryTimeAt;
    private Long leftSecond;

    public GroupBookingJoiner toLeftSecond(){
        this.leftSecond = Duration.between(LocalDateTime.now(), expiryTimeAt).getSeconds();
        return this;
    }
}
