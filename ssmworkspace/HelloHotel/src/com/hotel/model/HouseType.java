package com.hotel.model;

/**
 * Created by JW.
 * User: JW
 * Date: Dec 26, 2016 
 * Time: 5:27:47 PM
 *
 * com.hotel.model.HouseType
 */
public class HouseType extends BaseModel {
	private String name;
	private String description;
	private int status = STATUS.USED;
	public static class STATUS{
		public static final int DELETED = 0;
		public static final int USED = 1;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
