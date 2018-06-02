package com.mail;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

public class SendMail {

	/**
	 * @param args
	 * @throws MessagingException 
	 */
	public static void main(String[] args) throws MessagingException {
     Properties props = new Properties();
     props.setProperty("", "true");
     Session session = Session.getDefaultInstance(props);
     Message msg = new MimeMessage(session);
     
     Transport transport = session.getTransport();
     transport.sendMessage(msg, new Address[]{});
	}

}
