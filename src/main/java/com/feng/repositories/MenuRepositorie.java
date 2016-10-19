package com.feng.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.feng.base.BaseRepositorie;
import com.feng.entity.MenuEntity;

public interface MenuRepositorie extends BaseRepositorie<MenuEntity>{

	@Query(value="FROM MenuEntity WHERE menuGrade = 1 AND removeMark = false ORDER BY menuRank desc")
	List<MenuEntity> findAllGreadFirstMenus();

}
