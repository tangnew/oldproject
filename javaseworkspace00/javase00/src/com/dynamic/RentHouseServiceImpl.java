package com.dynamic;

public class RentHouseServiceImpl implements RentHouseService {
	@Override
	public String wantToRentHouse(String houseAddress) {
		System.out.println("I have an house to rent, please conact to me!["
				+ houseAddress + "]");
		return houseAddress;
	}

}
