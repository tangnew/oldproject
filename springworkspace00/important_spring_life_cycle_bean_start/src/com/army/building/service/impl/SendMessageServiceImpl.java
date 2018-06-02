package com.army.building.service.impl;

import com.army.building.service.SendMessageService;

public class SendMessageServiceImpl implements SendMessageService {

	@Override
	public void sendMessage(String message) {
		System.out.println("message:" + message);
	}


}
