package com.service.impl;

import com.modual.User;
import com.service.UserService;

public class UserServiceImpl0 implements UserService {

	@Override
	public void add(User user) {
		System.out.println(this.getClass().getName() + ".add()");
	}

	@Override
	public void update(User user) {
		System.out.println(this.getClass().getName() + ".update()");
	}

}
