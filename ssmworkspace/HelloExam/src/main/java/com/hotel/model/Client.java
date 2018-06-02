package com.hotel.model;


/**
 * Created by JW.
 * User: JW
 * Date: Dec 23, 2016 
 * Time: 5:22:17 PM
 *
 * com.hotel.model.Client
 */
public class Client extends BaseModel {
	private String name;
	private String identity;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

}
