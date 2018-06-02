package com.service.impl;

import com.model.User;
import com.service.UserService;

public class UserServiceImpl0 implements UserService {
	private User user;

	public void setUser(User user) {
		this.user = user;
	}

	public UserServiceImpl0() {
		System.out.println("constructor0!");
	}

	@Override
	public void add(User user) {
		System.out.println(this.getClass().getName() + ":add");
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
