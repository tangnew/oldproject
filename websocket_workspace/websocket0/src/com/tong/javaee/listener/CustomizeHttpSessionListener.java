package com.tong.javaee.listener;

import com.tong.javaee.pool.JavaEESessionPool;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by IDEA.
 * User: tjj.
 * Date : 2015/1/9
 * Time : 23:22
 */
public class CustomizeHttpSessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        JavaEESessionPool.remove(httpSessionEvent.getSession().getId());
    }
}
