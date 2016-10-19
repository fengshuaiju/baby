package com.feng.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name="menu")
public class MenuEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6702068179824994933L;
	
	//菜单名称
	@Column(name="menuName")
	private String menuName;
	
	//菜单等级
	@Column(name="menuGrade")
	private String menuGrade;
	
	//排序
	@Column(name="menuRank")
	private String menuRank;
	
	//菜单url
	@Column(name="menuUrl")
	private String menuUrl;
	
	//菜单描述
	@Column(name="menuNote")
	private String menuNote;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "role_menu", joinColumns = { @JoinColumn(name = "menuid") }, 
		inverseJoinColumns = {@JoinColumn(name = "roleid") })
	private Set<RoleEntity> roles = new HashSet<RoleEntity>();

	//自身一对多关联
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "fid")
	private MenuEntity menu;

	@OneToMany(mappedBy = "menu",fetch=FetchType.EAGER)
	@OrderBy("menuRank desc")
	private Set<MenuEntity> menus = new HashSet<>();
	
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

	public Set<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleEntity> roles) {
		this.roles = roles;
	}

	public MenuEntity getMenu() {
		return menu;
	}

	public void setMenu(MenuEntity menu) {
		this.menu = menu;
	}

	public Set<MenuEntity> getMenus() {
		return menus;
	}

	public void setMenus(Set<MenuEntity> menus) {
		this.menus = menus;
	}
	
}