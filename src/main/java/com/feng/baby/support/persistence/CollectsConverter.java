package com.feng.baby.support.persistence;

import javax.persistence.AttributeConverter;
import java.util.Collection;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toSet;

/**
 * Created by minggaoxi on 09/11/2017.
 */
public class CollectsConverter implements AttributeConverter<Collection<String>, String> {
    @Override
    public String convertToDatabaseColumn(Collection<String> attribute) {
        return attribute.stream().collect(joining(";"));
    }

    @Override
    public Collection<String> convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }

        return Stream.of(dbData.split(";")).collect(toSet());
    }
}
