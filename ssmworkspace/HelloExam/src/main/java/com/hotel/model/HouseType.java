package com.hotel.model;

/**
 * Created by JW.
 * User: JW
 * Date: Dec 23, 2016 
 * Time: 5:27:47 PM
 *
 * com.hotel.model.HouseType
 */
public class HouseType extends BaseModel {
	private String name;
	private String description;

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
