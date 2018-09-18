package com.feng.baby.application.representation;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class EvaluateRepresentation {

    private String username;
    private String avatarUrl;
    private String nickName;

    private String objectId;
    private LocalDateTime createdAt;
    private String evaluateId;

    private String label;
    private String content;
    private Set<String> pics;
    private Map<String,Integer> score;

    private boolean hasReply;

    private List<EvaluateRepresentation> reply;
}
