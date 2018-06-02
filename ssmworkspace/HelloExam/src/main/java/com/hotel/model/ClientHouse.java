package com.hotel.model;


/**
 * Created by JW.
 * User: JW
 * Date: Dec 23, 2016 
 * Time: 5:24:03 PM
 *
 * com.hotel.model.ClientHouse
 */
public class ClientHouse {
	private String batchNo;
	private String houseId;
	private String clientId;
	private String startTime;
	private String endTime;
	private int status;
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getHouseId() {
		return houseId;
	}
	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
