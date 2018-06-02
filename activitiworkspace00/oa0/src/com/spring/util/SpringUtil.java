package com.spring.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class SpringUtil {

	public static String getCurrentUserName() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		String name = (String) request.getSession().getAttribute("tuser");
		return name;
	}
	

}
