package com.tong.javaee.servlet;

import com.tong.bean.Teacher;
import com.tong.javaee.pool.SessionKey;
import com.tong.javaee.pool.UserWebSocketPool;
import com.tong.javaee.servlet.websocket.UserWebSocket;
import org.eclipse.jetty.websocket.api.Session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Set;

/**
 * Created by IDEA.
 * User: tjj.
 * Date : 2015/1/11
 * Time : 13:06
 */
public class FileUpAndDownloadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Teacher t = (Teacher) req.getSession().getAttribute(SessionKey
                .LOGIN_USER);
        Set<Session> sessionSet = UserWebSocketPool.getSessions(t.getId());
        if (null != sessionSet) {
            for (Session temp : sessionSet) {
                if (temp.isOpen()) {
                    temp.getRemote().sendString(((HttpSession)temp
                            .getUpgradeRequest().getSession()).getId()+
                            " say:" + req
                            .getParameter("fileName"));
                }
            }
        }
        resp.getWriter().println(req.getParameter("fileName"));
    }
}
