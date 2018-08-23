package com.feng.baby.application.representation;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GoodsCutDownHelper {
    private String cutDownId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    private String participant;
    private String participantNickName;
    private String participantAvatarUrl;
    private Double cutDownPrice;
}
