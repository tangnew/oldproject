package com.tong.controller;

import org.eclipse.jetty.websocket.servlet.ServletUpgradeRequest;
import org.eclipse.jetty.websocket.servlet.ServletUpgradeResponse;
import org.eclipse.jetty.websocket.servlet.WebSocketCreator;


public class UserWebSocketCreator implements WebSocketCreator{

	@Override
	public Object createWebSocket(ServletUpgradeRequest arg0,
			ServletUpgradeResponse arg1) {
		return new UserWebSocket();
	}
	

}
