package com.hotel.model;


/**
 * Created by JW.
 * User: JW
 * Date: Dec 26, 2016 
 * Time: 5:21:07 PM
 *
 * com.hotel.model.House
 */
public class House extends BaseModel {
	public static class STATUS{
		public static final int DELETED = 0;
		public static final int USED = 1;
		public static final int NOT_USED = 2;
	}
	
	private String houseTypeId;
	private String number;
	private String description;
	private int currentStatus = STATUS.NOT_USED;

	public String getHouseTypeId() {
		return houseTypeId;
	}

	public void setHouseTypeId(String houseTypeId) {
		this.houseTypeId = houseTypeId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(int currentStatus) {
		this.currentStatus = currentStatus;
	}
}
