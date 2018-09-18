package com.feng.baby.application.service;

import com.feng.baby.application.command.UserAddressAddOrUpdate;
import com.feng.baby.application.representation.Address;
import com.feng.baby.support.utils.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static sprout.jooq.generate.Tables.USER_ADDRESS;

@Slf4j
@Service
public class UserAddressService {

    private final DSLContext jooq;

    @Autowired
    UserAddressService(DSLContext jooq) {
        this.jooq = jooq;
    }


    public Address defaultAddress(String username) {
        return jooq.selectFrom(USER_ADDRESS)
                .where(USER_ADDRESS.USERNAME.eq(username))
                .and(USER_ADDRESS.IS_DEFAULT.isTrue())
                .and(USER_ADDRESS.IS_REMOVE.isFalse())
                .fetchOptionalInto(Address.class)
                .orElse(null);
    }

    public List<Address> addressList(String username) {
        return jooq.selectFrom(USER_ADDRESS)
                .where(USER_ADDRESS.USERNAME.eq(username))
                .and(USER_ADDRESS.IS_REMOVE.isFalse())
                .fetchInto(Address.class);
    }

    public void delete(String userAddressId, String username) {
        jooq.update(USER_ADDRESS)
                .set(USER_ADDRESS.IS_REMOVE, true)
                .where(USER_ADDRESS.USER_ADDRESS_ID.eq(userAddressId))
                .and(USER_ADDRESS.USERNAME.eq(username))
                .execute();
    }

    public Address findAddress(String userAddressId, String username) {
        return jooq.selectFrom(USER_ADDRESS)
                .where(USER_ADDRESS.USERNAME.eq(username))
                .and(USER_ADDRESS.USER_ADDRESS_ID.eq(userAddressId))
                .and(USER_ADDRESS.IS_REMOVE.isFalse())
                .fetchOptionalInto(Address.class)
                .orElseThrow(ResourceNotFoundException::new);
    }

    public void newAddress(String username, UserAddressAddOrUpdate userAddressAddOrUpdate) {
        jooq.insertInto(USER_ADDRESS)
                .set(USER_ADDRESS.USER_ADDRESS_ID, StringUtils.isEmpty(userAddressAddOrUpdate.getUserAddressId()) ? UUID.randomUUID().toString() : userAddressAddOrUpdate.getUserAddressId())
                .set(USER_ADDRESS.USERNAME, username)
                .set(USER_ADDRESS.PROVINCE, userAddressAddOrUpdate.getProvince())
                .set(USER_ADDRESS.PROVINCE_CODE, userAddressAddOrUpdate.getProvinceCode())
                .set(USER_ADDRESS.CITY, userAddressAddOrUpdate.getCity())
                .set(USER_ADDRESS.CITY_CODE, userAddressAddOrUpdate.getCityCode())
                .set(USER_ADDRESS.AREA, userAddressAddOrUpdate.getArea())
                .set(USER_ADDRESS.AREA_CODE, userAddressAddOrUpdate.getAreaCode())
                .set(USER_ADDRESS.ADDRESS, userAddressAddOrUpdate.getAddress())
                .set(USER_ADDRESS.IS_DEFAULT, true)
                .set(USER_ADDRESS.LINK_MAN, userAddressAddOrUpdate.getLinkMan())
                .set(USER_ADDRESS.MOBILE, userAddressAddOrUpdate.getMobile())
                .set(USER_ADDRESS.IS_REMOVE, false)
                .set(USER_ADDRESS.POSTAL_CODE, userAddressAddOrUpdate.getAreaCode())
                .onDuplicateKeyUpdate()
                .set(USER_ADDRESS.USERNAME, username)
                .set(USER_ADDRESS.PROVINCE, userAddressAddOrUpdate.getProvince())
                .set(USER_ADDRESS.PROVINCE_CODE, userAddressAddOrUpdate.getProvinceCode())
                .set(USER_ADDRESS.CITY, userAddressAddOrUpdate.getCity())
                .set(USER_ADDRESS.CITY_CODE, userAddressAddOrUpdate.getCityCode())
                .set(USER_ADDRESS.AREA, userAddressAddOrUpdate.getArea())
                .set(USER_ADDRESS.AREA_CODE, userAddressAddOrUpdate.getAreaCode())
                .set(USER_ADDRESS.ADDRESS, userAddressAddOrUpdate.getAddress())
                .set(USER_ADDRESS.IS_DEFAULT, true)
                .set(USER_ADDRESS.LINK_MAN, userAddressAddOrUpdate.getLinkMan())
                .set(USER_ADDRESS.MOBILE, userAddressAddOrUpdate.getMobile())
                .set(USER_ADDRESS.IS_REMOVE, false)
                .set(USER_ADDRESS.POSTAL_CODE, userAddressAddOrUpdate.getPostalCode())
                .execute();
    }
}
