package com.exam.javaee;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.manager.SessionManager;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by JW.
 * User: JW
 * Date: Nov 21, 2016 
 * Time: 9:05:20 AM
 *
 * com.exam.javaee.AuthorityFilter
 */
public class AuthorityFilter implements Filter {

	
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String context = request.getServletContext().getContextPath();
		System.out.println("context= " + context);
		String uri = ((HttpServletRequest) request).getRequestURI();
		System.out.println("uri= " + uri);
		if (uri.startsWith(context+"/jw/account/login")
				|| uri.startsWith(context + "/jw/account/logout") 
				|| uri.startsWith(context + "/jw/account/register")) {
			chain.doFilter(request, response);
			return;
		}
		
		if (uri.startsWith(context+"/app/main.html") || uri.startsWith(context+"/jw/")) {
			Object val = SessionManager.getSessionValue(req,
					SessionManager.USER);
			if (null == val) {
				ObjectMapper o = new ObjectMapper();
				
				Map<String,Object> result = new HashMap<String, Object>();
				result.put("code",300);
				result.put("message","session已经过期");
				resp.setCharacterEncoding("utf-8");
				resp.getWriter().write(o.writeValueAsString(result));
				resp.getWriter().flush();
				return;
			}
		}

		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
