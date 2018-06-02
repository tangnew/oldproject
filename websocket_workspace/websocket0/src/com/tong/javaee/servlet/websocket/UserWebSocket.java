package com.tong.javaee.servlet.websocket;

import com.tong.bean.Teacher;
import com.tong.javaee.pool.JavaEESessionPool;
import com.tong.javaee.pool.SessionKey;
import com.tong.javaee.pool.UserWebSocketPool;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.WebSocketAdapter;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by IDEA.
 * User: tjj.
 * Date : 2015/1/9
 * Time : 23:15
 */
public class UserWebSocket extends WebSocketAdapter {

    private final static AtomicInteger connectons = new AtomicInteger();
    private String teacherId;

    private int seq;

    public int getSeq() {
        return seq;
    }

    public UserWebSocket(String teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public void onWebSocketClose(int statusCode, String reason) {
        UserWebSocketPool.removeSession(teacherId, getSession());
        super.onWebSocketClose(statusCode, reason);
    }

    @Override
    public void onWebSocketConnect(Session sess) {
        super.onWebSocketConnect(sess);
        seq = connectons.incrementAndGet();
        UserWebSocketPool.add(teacherId, sess);
        returnMessage("Welcome to WebSocket!");
    }

    @Override
    public void onWebSocketError(Throwable cause) {
        UserWebSocketPool.removeSession(teacherId, getSession());
        super.onWebSocketError(cause);
    }

    @Override
    public void onWebSocketText(String message) {
        super.onWebSocketText(message);
        returnMessage("You say:" + message);
    }

    private void returnMessage(String message) {
        if (isConnected()) {
            try {
                getSession().getRemote().sendString(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
