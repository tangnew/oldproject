package com.army.building.service.impl;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;

import com.army.building.service.SendMail;

public class UseJavaMailSenderAndMimeMessagePreparator implements SendMail {

	private JavaMailSender javaMailsender;

	private String toMail;

	private String fromMail;

	public void setFromMail(String fromMail) {
		this.fromMail = fromMail;
	}

	public void setToMail(String toMail) {
		this.toMail = toMail;
	}

	public void setJavaMailsender(JavaMailSender javaMailsender) {
		this.javaMailsender = javaMailsender;
	}

	@Override
	public void sendMessage(String message) {
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(toMail));
				mimeMessage.setFrom(new InternetAddress(fromMail));
				mimeMessage.setSubject("This is subject");
				mimeMessage
						.setText("UseJavaMailSenderAndMimeMessagePreparator");
			}
		};

		javaMailsender.send(preparator);
	}

}
