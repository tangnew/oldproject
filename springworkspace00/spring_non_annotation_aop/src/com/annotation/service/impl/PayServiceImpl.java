package com.annotation.service.impl;

import com.annotation.service.PayService;

public class PayServiceImpl implements PayService {

	@Override
	public void pay() {
		System.out.println("======paying======");
	}

	@Override
	public void savePay() {
		System.out.println("======save pay======");

	}

	@Override
	public void payMoney(String money) {

		System.out.println("======pay money:" + money + "======");
	}

}
