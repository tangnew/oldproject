package com.service.impl;

import com.modual.User;
import com.service.UserService;

public class UserServiceImpl1 implements UserService {

	@Override
	public void add(User user) {
		System.out.println(this.getClass().getName() + ":add");
	}

	@Override
	public void update(User user) {
		System.out.println(this.getClass().getName() + ":update");

	}

	@Override
	public void addDefault() {
		System.out.println(this.getClass().getName() + ":addDefault");
	}

}
