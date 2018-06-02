package com.hotel.model;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by JW.
 * User: JW
 * Date: Dec 26, 2016 
 * Time: 5:24:03 PM
 *
 * com.hotel.model.ClientHouse
 */
public class ClientHouse extends BaseModel{
	public static class STATUS{
		public static final int DELETED = 0;
		public static final int USED = 1;
		public static final int NOT_USED = 2;
	}
	private String batchNo;
	private String houseNumber;
	private String houseThing;
	private int clientNumber;
	private String startTime;
	private String endTime;
	private int status = STATUS.USED;
	private String houseType;
	
	private List<Client> clients = new ArrayList<Client>();
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	
	public String getHouseNumber() {
		return houseNumber;
	}
	
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
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
	/**
	 * @return the houseThing
	 */
	public String getHouseThing() {
		return houseThing;
	}
	/**
	 * @param houseThing the houseThing to set
	 */
	public void setHouseThing(String houseThing) {
		this.houseThing = houseThing;
	}
	/**
	 * @return the clientNumber
	 */
	public int getClientNumber() {
		return clientNumber;
	}
	/**
	 * @param clientNumber the clientNumber to set
	 */
	public void setClientNumber(int clientNumber) {
		this.clientNumber = clientNumber;
	}
	public String getHouseType() {
		return houseType;
	}
	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}
	public List<Client> getClients() {
		return clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
	
}
