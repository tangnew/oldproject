package com.army.building.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.army.building.model.User;
import com.army.building.service.UserService;

@Controller(value = "userController")
public class UserController {

	@Resource(name = "userService")
	private UserService userService;

	public void add(User user) {
		System.out.println("userController");
		userService.add(user);
	}
}
