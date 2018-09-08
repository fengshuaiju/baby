package com.feng.baby.model;

import java.util.HashMap;
import java.util.Map;

public class SignRule {

    public static final Integer FIRSTDAY = 1;

    public static Map<Integer, Integer> data = new HashMap<>();

    static {
        data.put(1, 1);
        data.put(2, 1);
        data.put(3, 2);
        data.put(4, 2);
        data.put(5, 2);
        data.put(6, 4);
        data.put(7, 4);
    }

}
