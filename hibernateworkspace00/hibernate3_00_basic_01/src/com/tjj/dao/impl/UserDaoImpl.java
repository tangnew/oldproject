package com.tjj.dao.impl;

import java.util.List;

import com.tjj.dao.AbstractDao;
import com.tjj.dao.UserDao;
import com.tjj.model.User;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {

	@Override
	public void addUser(User user) {
		super.save(user);
	}

	@Override
	public List<User> findAllUser() {
		return super.findAll(User.class);
	}

	@Override
	public User getUserById(Long id) {
		return super.get(User.class, id);
	}

	@Override
	public User loadUserById(Long id) {
		return super.load(User.class, id);
	}
	
	

}
