package com.tong.controller;

import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

public class FileUpAndDownloadServlet extends WebSocketServlet {

	@Override
	public void configure(WebSocketServletFactory factory) {
		System.out.println("servlet.......");
		factory.register(UserWebSocketCreator.class);
	}
	

}
