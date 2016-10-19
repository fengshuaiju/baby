package com.feng.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat;

@MappedSuperclass
public class BaseEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6675858340240479902L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "creationTime")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private DateTime creationTime;
	
	@Column(name = "updateTime")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private DateTime updateTime;
	
	@Column(name = "removeMark")
	private boolean removeMark = false;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCreationTime() {
		return creationTime == null ? null : creationTime.toString(ISODateTimeFormat.dateHourMinuteSecond());
	}

	public void setCreationTime(DateTime creationTime) {
		this.creationTime = creationTime;
	}

	public String getUpdateTime() {
		return updateTime == null ? null : updateTime.toString(ISODateTimeFormat.dateHourMinuteSecond());
	}

	public void setUpdateTime(DateTime updateTime) {
		this.updateTime = updateTime;
	}

	public boolean isRemoveMark() {
		return removeMark;
	}

	public void setRemoveMark(boolean removeMark) {
		this.removeMark = removeMark;
	}
}