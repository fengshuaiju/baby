package com.feng.baby.support.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.vavr.control.Try;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class MapToStringConverterUtils {

    public static String convertToDatabaseColumn(Map attribute) {
        return Try.of(() -> JSON.toJSONString(attribute)).getOrElseThrow(() -> new RuntimeException("convert to json failed: " + attribute));
    }

    public static Map convertToEntityAttribute(String dbData) {
        return Try.of(() -> {
            if (StringUtils.isBlank(dbData)) {
                return null;
            } else {
                return JSONObject.parseObject(dbData, Map.class);
            }
        }).getOrElseThrow(() -> new RuntimeException("convert to object failed: " + dbData));
    }

}
