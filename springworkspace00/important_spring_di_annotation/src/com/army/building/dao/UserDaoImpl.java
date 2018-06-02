package com.army.building.dao;

import org.springframework.stereotype.Repository;

import com.army.building.model.User;

@Repository(value = "userDao")
public class UserDaoImpl implements UserDao {

	@Override
	public void add(User user) {
		System.out.println("userDao");
		System.out.println("add user:" + user.getName());
	}

}
