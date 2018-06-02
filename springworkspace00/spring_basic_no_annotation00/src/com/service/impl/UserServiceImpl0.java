package com.service.impl;

import com.modual.User;
import com.service.UserService;

public class UserServiceImpl0 implements UserService {

	private User user;

	public UserServiceImpl0(User user) {
		this.user = user;
	}

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
		System.out.println(this.getClass().getName() + ":addDefault:"
				+ this.user.getId() + "=" + this.user.getName());
	}

}
