/**
 * 
 */
package com.jw.hs.management.handler;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.jw.hs.management.exception.BaseSupportException;

/**
 * @author Jianjun Tang
 *
 * 2017年9月16日 下午11:24:08
 * 
 */
public class ManagementExceptionHandler implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		BaseSupportException bs =((BaseSupportException)ex);
		System.out.println("test  handler:" +((BaseSupportException)ex).getMessage());
		try {
			response.getWriter().print(bs.getCode());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
