package com.army.building.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.army.building.dao.UserDao;
import com.army.building.model.User;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

	@Resource(name = "userDao")
	private UserDao userDao;

	@Override
	public void add(User user) {
		System.out.println("userService");
		userDao.add(user);
	}

	@Override
	public User update(User user) {
		System.out.println("userService update");
		user.setName("return");
		System.out.println("return " + user.getName());
		return user;
	}

	@Override
	public void delete(User user, User user1) {
		System.out.println("userService delete");
	}

	@Override
	public void exceptions() {
		System.out.println("userService exceptions:"+userDao.getClass());
		throw new RuntimeException("test exception!");
	}

}
