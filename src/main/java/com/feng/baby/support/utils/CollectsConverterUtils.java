package com.feng.baby.support.utils;

import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toSet;

public class CollectsConverterUtils {

    public static String convertToDatabaseColumn(Set<String> originalData) {
        return originalData.stream().collect(joining(";"));
    }

    public static Set<String> convertToSet(String transformation) {
        if (transformation == null) {
            return null;
        }
        return Stream.of(transformation.split(";")).collect(toSet());
    }

}
