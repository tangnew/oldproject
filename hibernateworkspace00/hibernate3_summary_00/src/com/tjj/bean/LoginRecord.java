package com.tjj.bean;

import java.util.Date;

public class LoginRecord {
	private Long id;
	private String remoteIp;
	private Date createdTime;
	private Date updatedTime;
	private Student student;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRemoteIp() {
		return remoteIp;
	}
	public void setRemoteIp(String remoteIp) {
		this.remoteIp = remoteIp;
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
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "LoginRecord [id=" + id + ", remoteIp=" + remoteIp
				+ ", createdTime=" + createdTime + ", updatedTime="
				+ updatedTime + ", student=" + student + "]";
	}
	
}
