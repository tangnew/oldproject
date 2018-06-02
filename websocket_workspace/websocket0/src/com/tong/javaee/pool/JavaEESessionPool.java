package com.tong.javaee.pool;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IDEA.
 * User: tjj.
 * Date : 2015/1/9
 * Time : 23:27
 */
public final class JavaEESessionPool {
    private static final Map<String, HttpSession> storageMap = new
            HashMap<>();

    public static void add(String httpSessionId, HttpSession session) {
        storageMap.put(httpSessionId, session);
    }

    public static HttpSession get(String httpSessionId) {
        return storageMap.get(httpSessionId);
    }
    public static void remove(String httpSessionId){
        storageMap.remove(httpSessionId);
    }
}
