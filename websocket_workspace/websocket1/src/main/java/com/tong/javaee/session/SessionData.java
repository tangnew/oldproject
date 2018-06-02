package com.tong.javaee.session;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IDEA.
 * User: tjj.
 * Date : 2015/1/11
 * Time : 21:11
 */
public class SessionData {
    private final static Map<Object, Object> storage = new HashMap<>();

    public static void put(Object key, Object value) {
        storage.put(key, value);
    }
}
