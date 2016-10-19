package com.feng.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanUtils;

import com.feng.entity.MenuEntity;

public class MenuModel {
	
	private Long id;

	private String menuName;

	private String menuGrade;

	private String menuRank;

	private String menuUrl;

	private String menuNote;
	
	private List<MenuModel> meuns = new ArrayList<>();
	
	public MenuModel(){
		
	}
	
	public MenuModel(MenuEntity menuEntity) {
		if (!menuEntity.isRemoveMark()) {
			BeanUtils.copyProperties(menuEntity, this);
			Set<MenuEntity> nextGrades = menuEntity.getMenus();
			if (nextGrades != null && nextGrades.size() > 0) {
				this.meuns.clear();
				for (MenuEntity nextGrade : nextGrades) {
					meuns.add(new MenuModel(nextGrade));
				}
			}
		}
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuGrade() {
		return menuGrade;
	}

	public void setMenuGrade(String menuGrade) {
		this.menuGrade = menuGrade;
	}

	public String getMenuRank() {
		return menuRank;
	}

	public void setMenuRank(String menuRank) {
		this.menuRank = menuRank;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public String getMenuNote() {
		return menuNote;
	}

	public void setMenuNote(String menuNote) {
		this.menuNote = menuNote;
	}

	public List<MenuModel> getMeuns() {
		return meuns;
	}

	public void setMeuns(List<MenuModel> meuns) {
		this.meuns = meuns;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 重写Hashcode和equals方法，防止出现重复菜单
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((menuGrade == null) ? 0 : menuGrade.hashCode());
		result = prime * result + ((menuName == null) ? 0 : menuName.hashCode());
		result = prime * result + ((menuNote == null) ? 0 : menuNote.hashCode());
		result = prime * result + ((menuRank == null) ? 0 : menuRank.hashCode());
		result = prime * result + ((menuUrl == null) ? 0 : menuUrl.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuModel other = (MenuModel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (menuGrade == null) {
			if (other.menuGrade != null)
				return false;
		} else if (!menuGrade.equals(other.menuGrade))
			return false;
		if (menuName == null) {
			if (other.menuName != null)
				return false;
		} else if (!menuName.equals(other.menuName))
			return false;
		if (menuNote == null) {
			if (other.menuNote != null)
				return false;
		} else if (!menuNote.equals(other.menuNote))
			return false;
		if (menuRank == null) {
			if (other.menuRank != null)
				return false;
		} else if (!menuRank.equals(other.menuRank))
			return false;
		if (menuUrl == null) {
			if (other.menuUrl != null)
				return false;
		} else if (!menuUrl.equals(other.menuUrl))
			return false;
		return true;
	}
	
}
