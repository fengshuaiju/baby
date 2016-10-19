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
@Table(name="user")
public class UserEntity extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1877312406266364501L;

	@Column(name="userAccount")
	private String userAccount;
	
	@Column(name="password")
	private String password;
	
	@Column(name="salt")
	private String salt;
	
	@Column(name="nickName")
	private String nickName;
	
	@Column(name="moble")
	private String moble;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = {@JoinColumn(name = "userid")}, inverseJoinColumns = {@JoinColumn(name = "roleid")})
	private Set<RoleEntity> roles = new HashSet<RoleEntity>();
	
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getMoble() {
		return moble;
	}
	public void setMoble(String moble) {
		this.moble = moble;
	}
	public Set<RoleEntity> getRoles() {
		return roles;
	}
	public void setRoles(Set<RoleEntity> roles) {
		this.roles = roles;
	}
}