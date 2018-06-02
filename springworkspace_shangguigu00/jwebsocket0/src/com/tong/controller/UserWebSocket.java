package com.tong.controller;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.WebSocketAdapter;

public class UserWebSocket extends WebSocketAdapter {
	@Override
	public void onWebSocketConnect(Session sess) {
		super.onWebSocketConnect(sess);
	}

	@Override
	public void onWebSocketText(String message) {
		System.out.println("message:"+message);
	}
}
