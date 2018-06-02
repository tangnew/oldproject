package com.tong.javaee.pool;

import org.eclipse.jetty.websocket.api.Session;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by IDEA.
 * User: tjj.
 * Date : 2015/1/10
 * Time : 12:46
 */
public class UserWebSocketPool {
    /**
     * key是Teacher的id,value是一系列的sessionid集合
     */
    private final static Map<String, Set<Session>> storage = new
            HashMap<>();

    public static void add(String teacherId, Session
            session) {
        Set<Session> sessions = storage.get(teacherId);
        if (null == sessions) {
            sessions = new HashSet<Session>();
            storage.put(teacherId, sessions);
        }
        sessions.add(session);
    }

    public static Set<Session> getSessions(String teacherId) {
        return storage.get(teacherId);
    }

    public static void removeSession(String teacherId, Session
            session) {
        Set<Session> sessions = storage.get(teacherId);
        if (null != sessions) {
            sessions.remove(session);
            if (sessions.isEmpty()) {
                storage.remove(teacherId);
            }
        }
    }
}
