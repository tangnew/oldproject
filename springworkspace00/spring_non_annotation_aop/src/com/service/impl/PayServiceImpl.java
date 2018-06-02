package com.service.impl;

import com.service.PayService;

public class PayServiceImpl implements PayService {

	@Override
	public void pay() {
		System.out.println("====pay====");

	}

	@Override
	public void borrow() {
		System.out.println("====borrow====");

	}

	@Override
	public String getMoney(String money) {
		System.out.println("====" + money);
		return money;
	}

	@Override
	public void sayMoney(String money, String money1) {
		System.out.println("=====" + money + ";" + money1 + "====");

	}

}
