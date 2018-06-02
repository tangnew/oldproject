package com.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.spring.util.Constant;

public class LoginFilter extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String servletPath = request.getServletPath();
		String uri = request.getRequestURI();
		System.out.println("servletPath=" + servletPath + ",uri=" + uri);

		if(servletPath.endsWith("loginController.do")){
			return super.preHandle(request, response, handler);
		}
		
		if (request.getSession().getAttribute(Constant.T_USER) == null) {
			request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
			return false;
		}

		return super.preHandle(request, response, handler);
	}
}
