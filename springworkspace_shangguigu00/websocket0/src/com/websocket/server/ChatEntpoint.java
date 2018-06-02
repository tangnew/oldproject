package com.websocket.server;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

import javax.websocket.server.ServerEndpoint;

//@ServerEndpoint(value="/websocket/cjat")
public class ChatEntpoint {

	private static String GUEST_PREFIX ="访客";
	private static AtomicInteger commectionsIds = new AtomicInteger();
	private static Set<ChatEntpoint> clientSet = new CopyOnWriteArraySet<>();
	


}
