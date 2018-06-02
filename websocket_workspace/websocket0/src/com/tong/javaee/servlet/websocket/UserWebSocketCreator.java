package com.tong.javaee.servlet.websocket;

import com.tong.bean.Teacher;
import com.tong.javaee.pool.JavaEESessionPool;
import com.tong.javaee.pool.SessionKey;
import org.eclipse.jetty.websocket.servlet.ServletUpgradeRequest;
import org.eclipse.jetty.websocket.servlet.ServletUpgradeResponse;
import org.eclipse.jetty.websocket.servlet.WebSocketCreator;

/**
 * Created by IDEA.
 * User: tjj.
 * Date : 2015/1/9
 * Time : 23:16
 */
public class UserWebSocketCreator implements WebSocketCreator {
    @Override
    public Object createWebSocket(ServletUpgradeRequest servletUpgradeRequest, ServletUpgradeResponse servletUpgradeResponse) {
        String jessionid = servletUpgradeRequest.getHttpServletRequest()
                .getParameter(SessionKey.JESSIONID);
        Teacher teacher = (Teacher) JavaEESessionPool.get(jessionid).getAttribute
                (SessionKey
                        .LOGIN_USER);
        return new UserWebSocket(teacher.getId());
    }
}
