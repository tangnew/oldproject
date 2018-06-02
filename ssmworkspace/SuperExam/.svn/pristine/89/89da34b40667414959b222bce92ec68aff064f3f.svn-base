package com.exam.manager;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.WebUtils;

/**
 * Created by JW.
 * User: JW
 * Date: Nov 21, 2016 
 * Time: 4:11:25 PM
 *
 * com.exam.controller.SessionManager
 */
public class SessionManager {

	public static final String USER = "user";
	public void getSession() {
		ServletRequestAttributes srq = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		srq.getRequest();
	}

	public static void setSession(HttpServletRequest request, String name,
			Object value) {
		WebUtils.setSessionAttribute(request, name, value);
	}

	public static void invalidateSession(HttpServletRequest request) {
		request.getSession().invalidate();
	}

	
	public static Object getSessionValue(HttpServletRequest request, String name) {
		return WebUtils.getSessionAttribute(request, name);
	}
}
