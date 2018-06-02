package com.exam.entity;

/**
 * Created by JW. User: JW Date: Nov 4, 2016 Time: 3:19:11 PM
 *
 * com.exam.entity.Account
 */
public class Account extends BaseEntity{
	public static class Status{
		static int valid = 1;
	}
	private String loginName;
	private String password;
	private Integer status = Status.valid;
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	
}
