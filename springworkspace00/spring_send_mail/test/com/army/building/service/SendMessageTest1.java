package com.army.building.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.army.building.service.impl.SimpleSendMessage;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/application.xml")
public class SendMessageTest1 {
	@Resource
	private ApplicationContext applicationContext;

	@Test
	public void test1() {
		SimpleSendMessage sendMessage = applicationContext.getBean(
				"sendMessage", SimpleSendMessage.class);
		sendMessage.sendMessage("This is a MailSender,SimpleMailMessage!");
	}

	@Test
	public void test2() {
		SendMail sender = applicationContext.getBean("sendMessage0",
				SendMail.class);
		sender.sendMessage("This is a UseJavaMailSenderAndMimeMessagePreparator!");
	}
}