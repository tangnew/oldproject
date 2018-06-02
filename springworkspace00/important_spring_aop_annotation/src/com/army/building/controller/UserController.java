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
		System.out.println(userService.getClass());
		System.out.println("userController");
		userService.add(user);
	}
	
	public void update(User user){
		System.out.println("userController update");
		user = userService.update(user);
		System.out.println(user.getName());
	}
	
	public void delete(User user){
		System.out.println("userController delete");
		userService.delete(user,user);
	}
	
	public void exception(){
		System.out.println("userController exception");
		System.out.println(userService.getClass());
		userService.exceptions();
	}
}
