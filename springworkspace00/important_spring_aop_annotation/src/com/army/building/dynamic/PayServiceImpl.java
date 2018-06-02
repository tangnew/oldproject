package com.army.building.dynamic;

public class PayServiceImpl implements PayService {

	@Override
	public boolean pay(double money) {
		System.out.println("pay:" + money);
		return false;
	}

}
