package com.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.util.Constant;

@Controller
@RequestMapping("/loginController.do")
public class LoginController {
	@RequestMapping(params = "home")
	public String home(HttpServletRequest request, String loginName) {
		request.getSession().setAttribute(Constant.T_USER, loginName);
		return "redirect:/productController.do?list";
	}

	@RequestMapping(params = "logout")
	public String logout(HttpServletRequest request, String loginName) {
		request.getSession().removeAttribute(Constant.T_USER);
		return "jsp/login";
	}
}
