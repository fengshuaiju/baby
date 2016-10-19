package com.feng.repositories;

import com.feng.base.BaseRepositorie;
import com.feng.entity.UserEntity;

public interface UserRepositorie extends BaseRepositorie<UserEntity>{

	UserEntity findByUserAccount(String userAccount);

}
