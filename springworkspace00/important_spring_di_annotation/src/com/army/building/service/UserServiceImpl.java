package com.army.building.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.army.building.dao.UserDao;
import com.army.building.model.User;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

	@Resource(name="userDao")
	private UserDao userDao;
	
	@Override
	public void add(User user) {
		System.out.println("userService");
   userDao.add(user);
	}

}
