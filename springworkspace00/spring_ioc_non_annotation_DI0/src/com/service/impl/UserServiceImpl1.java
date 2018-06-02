package com.service.impl;

import com.model.User;
import com.service.UserService;

public class UserServiceImpl1 implements UserService {
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
	
		this.user = user;
	}

	public UserServiceImpl1(User user) {
		System.out.println("setUser:"+(user == null));
	}
	
	public UserServiceImpl1() {
		System.out.println("constructor1!");
	}

	@Override
	public void add(User user) {
		System.out.println("add:"+(user == null));
	}

	@Override
	public void init() {
		System.out.println("init-method");

	}

	@Override
	public void destroy() {
		System.out.println("destroy-method");

	}

}
