package com.tong.javaee.pool;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by IDEA.
 * User: tjj.
 * Date : 2015/1/10
 * Time : 11:23
 */
public final class UserPool {
    /**
     * key是Teacher的id,value是一系列的httpSessionId集合
     */
    private final static Map<String, Set<String>> storage = new
            HashMap<>();

    public static void add(String teacherId, String httpSessionId) {
        Set<String> sessionIds = storage.get(teacherId);
        if (null == sessionIds) {
            sessionIds = new HashSet<>();
            storage.put(teacherId, sessionIds);
        }
        sessionIds.add(httpSessionId);
    }

    public static Set<String> getHttpSessionIds(String teacherId) {
        return storage.get(teacherId);
    }

    public static void removeTeacher(String teacherId, String httpSessionId) {
        Set<String> sessionIds = storage.get(teacherId);
        if (null != sessionIds && sessionIds.size() > 1) {
            sessionIds.remove(httpSessionId);
        } else {
            storage.remove(teacherId);
        }
    }

}
