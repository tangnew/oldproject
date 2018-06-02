package com.jw.hs.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jw.hs.management.exception.BaseSupportException;
/**
 * 
 * @author Jianjun Tang
 *
 * 2017年9月16日 下午11:23:15
 *
 */
@Controller
@RequestMapping("/api/param")
public class ResponseParameterController {

	@RequestMapping(value="/hello/{test}")
	@ResponseBody
	public String hello(@PathVariable Integer test) {
		if(1 == 1) {
			
			throw new BaseSupportException("bbba", "a");
		}
		return "hello test";
	}
}
