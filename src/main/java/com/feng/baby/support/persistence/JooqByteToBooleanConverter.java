package com.feng.baby.support.persistence;

import org.jooq.Converter;

public class JooqByteToBooleanConverter implements Converter<Byte, Boolean> {
    @Override
    public Boolean from(Byte databaseObject) {
        return databaseObject == null ? null : databaseObject == (byte)1;
    }

    @Override
    public Byte to(Boolean userObject) {
        return userObject == null ? null : userObject ? (byte)1 : (byte)0;
    }

    @Override
    public Class<Byte> fromType() {
        return Byte.class;
    }

    @Override
    public Class<Boolean> toType() {
        return Boolean.class;
    }
}
