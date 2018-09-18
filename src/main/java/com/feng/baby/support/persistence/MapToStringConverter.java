package com.feng.baby.support.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.vavr.control.Try;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.AttributeConverter;
import java.util.Map;

/**
 * Created by minggaoxi on 11/07/2017.
 */
public class MapToStringConverter implements AttributeConverter<Map, String> {
    private final static ObjectMapper mapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Map attribute) {
        return Try.of(() -> mapper.writeValueAsString(attribute)).getOrElseThrow(() -> new RuntimeException("convert to json failed: " + attribute));
    }

    @Override
    public Map convertToEntityAttribute(String dbData) {
        return Try.of(() -> {
            if (StringUtils.isBlank(dbData)) {
                return null;
            } else {
                return mapper.readValue(dbData, Map.class);
            }
        }).getOrElseThrow(() -> new RuntimeException("convert to object failed: " + dbData));
    }

}
