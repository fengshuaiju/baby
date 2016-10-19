package com.feng.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class RoleEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4883038413820066264L;

	@Column(name="roleName")
	private String roleName;
	
	@Column(name="note")
	private String note;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "roleid") }, inverseJoinColumns = { @JoinColumn(name = "userid") })
	private Set<UserEntity> users = new HashSet<UserEntity>();

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "role_menu", joinColumns = {@JoinColumn(name = "roleid")}, inverseJoinColumns = {@JoinColumn(name = "menuid")})
	private Set<MenuEntity> menus = new HashSet<MenuEntity>();
	
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Set<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(Set<UserEntity> users) {
		this.users = users;
	}

	public Set<MenuEntity> getMenus() {
		return menus;
	}

	public void setMenus(Set<MenuEntity> menus) {
		this.menus = menus;
	}
	
}