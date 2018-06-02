package com.tjj.dao;

import java.util.List;

import com.tjj.model.User;

public interface UserDao {

	public void addUser(User user);

	public List<User> findAllUser();

	public User getUserById(Long id);
	
	public User loadUserById(Long id);
}
