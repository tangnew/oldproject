package com.tong.javaee.filter;

import com.tong.javaee.pool.JavaEESessionPool;
import com.tong.javaee.pool.SessionKey;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IDEA.
 * User: tjj.
 * Date : 2015/1/9
 * Time : 23:18
 */
public class PrivilegeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String uri = req.getRequestURI();
        if ("/login.html".equals(uri) || "/".equals(uri) || "/login".equals
                (uri)) {
            filterChain.doFilter(request, response);
            return;
        }

        String jessionId = request.getParameter(SessionKey.JESSIONID);
        Object teacherObj = req.getSession().getAttribute(SessionKey
                .LOGIN_USER);
        if (null == teacherObj) {
            if (null != JavaEESessionPool.get(jessionId)) {
                teacherObj = JavaEESessionPool.get(jessionId).getAttribute
                        (SessionKey.LOGIN_USER);
            }
        }


        if (null == teacherObj) {
            resp.sendRedirect("/login.html");
            return;
        }

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
