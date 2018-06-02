package com.hotel.model;

import java.util.Date;

/**
 * Created by JW.
 * User: JW
 * Date: Dec 23, 2016 
 * Time: 5:26:03 PM
 *
 * com.hotel.model.BaseModel
 */
public abstract class BaseModel {
	private String id;
	private Date createdTime;
	private Date updatedTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

}
