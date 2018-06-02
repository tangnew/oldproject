package com.exam.entity;


/**
 * Created by JW.
 * User: JW
 * Date: Nov 4, 2016 
 * Time: 4:36:06 PM
 *
 * com.exam.entity.User
 */
public class User extends BaseEntity {
	private String email;
	private String name;
	private Integer age;
	private Boolean gender;
	private String fkAccountId;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Boolean getGender() {
		return gender;
	}
	public void setGender(Boolean gender) {
		this.gender = gender;
	}
	public String getFkAccountId() {
		return fkAccountId;
	}
	public void setFkAccountId(String fkAccountId) {
		this.fkAccountId = fkAccountId;
	}
	

}
