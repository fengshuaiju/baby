package com.feng.baby.application.command;

import com.feng.baby.model.EvaluateType;
import lombok.Data;

import java.util.*;

@Data
public class EvaluateCommand {
    private Map<String, Integer> evaluateScore = new HashMap<>();
    private Set<String> pics = new HashSet<>();
    private EvaluateType type;
    private String objectId;
    private String content;
    private String label;

    private String username;
}
