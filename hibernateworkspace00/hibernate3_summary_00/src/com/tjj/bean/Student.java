package com.tjj.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Student {
	private Long id;
	private String name;
	private Boolean gender;
	private Boolean isValid;
	private Date createdTime;
	private Date updatedTime;
	private Set<LoginRecord> loginRecords = new HashSet<LoginRecord>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public Boolean getIsValid() {
		return isValid;
	}

	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public Set<LoginRecord> getLoginRecords() {
		return loginRecords;
	}

	public void setLoginRecords(Set<LoginRecord> loginRecords) {
		this.loginRecords = loginRecords;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gender=" + gender
				+ ", isValid=" + isValid + ", createdTime=" + createdTime
				+ ", updatedTime=" + updatedTime + ", loginRecords="
				+ loginRecords + "]";
	}

}
