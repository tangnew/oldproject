package com.exam.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exam.entity.User;
import com.exam.service.UserService;

/**
 * Created by JW.
 * User: JW
 * Date: Nov 4, 2016 
 * Time: 4:35:33 PM
 *
 * com.exam.controller.UserController
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource(name="userService")
	private UserService userService;

	@RequestMapping(value = "/info", method = RequestMethod.POST)
	@ResponseBody
	public User getUserInfo(String accountId){
		return userService.getUserByAccountId(accountId);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public User updateUserInfo(User user){
		return userService.updateUserByUser(user);
	}
}
