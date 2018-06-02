package com.tong.javaee.servlet;

import com.tong.bean.Teacher;
import com.tong.javaee.pool.JavaEESessionPool;
import com.tong.javaee.pool.SessionKey;
import com.tong.javaee.pool.UserPool;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IDEA.
 * User: tjj.
 * Date : 2015/1/9
 * Time : 23:12
 */
public class LoginServlet extends HttpServlet {
    private final static Map<String, Teacher> teachers = new HashMap<>();

    static {
        Teacher t1 = new Teacher("lisi1", "lisi1");
        Teacher t2 = new Teacher("lisi2", "lisi2");
        Teacher t3 = new Teacher("lisi3", "lisi3");
        Teacher t4 = new Teacher("lisi4", "lisi4");
        teachers.put("lisi1", t1);
        teachers.put("lisi2", t2);
        teachers.put("lisi3", t3);
        teachers.put("lisi4", t4);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loginName = req.getParameter("loginName");
        HttpSession session = req.getSession();
        Teacher teacher = teachers.get(loginName);
        session.setAttribute(SessionKey.LOGIN_USER, teacher);
        JavaEESessionPool.add(session.getId(), session);
        UserPool.add(teacher.getId(), session.getId());
        resp.sendRedirect("/simpleWS.html");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.invalidate();
    }
}
