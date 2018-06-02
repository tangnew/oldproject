package com.army.building.service.impl;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import com.army.building.service.SendMail;

public class SimpleSendMessage implements SendMail {

	private MailSender mailSender;

	private SimpleMailMessage templateMessage;

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void setTemplateMessage(SimpleMailMessage templateMessage) {
		this.templateMessage = templateMessage;
	}

	@Override
	public void sendMessage(String message) {
		SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);
		//msg.setTo("spring_java_accept@126.com");
		msg.setText(message);
		this.mailSender.send(msg);
	}

}
