/**
 * 
 */
package com.jw.hs.management.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jw.hs.management.exception.BaseSupportException;

/**
 * @author Jianjun Tang
 *
 * 2017年9月16日 下午11:43:45
 * 
 */
@ControllerAdvice
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(value=BaseSupportException.class)
	@ResponseBody
	public String ok(BaseSupportException bse) {
		System.out.println("bse");
		return "ok";
	}
}
