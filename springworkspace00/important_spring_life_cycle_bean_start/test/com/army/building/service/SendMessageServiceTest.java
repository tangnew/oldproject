package com.army.building.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SendMessageServiceTest {

	private ApplicationContext applicationContext;

	@Test
	public void testSendMessage0() {
		applicationContext = new ClassPathXmlApplicationContext(
				"classpath:application*.xml");
//		SendMessageService sendMessage = applicationContext.getBean(
//				"sendMessageService", SendMessageService.class);
//		sendMessage.sendMessage("hello zhangsan");
		
	}
}
