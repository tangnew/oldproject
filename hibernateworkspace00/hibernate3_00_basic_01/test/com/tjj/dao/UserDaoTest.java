package com.tjj.dao;

import java.util.List;

import org.junit.Test;

import com.tjj.dao.impl.UserDaoImpl;
import com.tjj.model.User;

public class UserDaoTest {

	@Test
	public void testAddUser00() {
		UserDao userDao = new UserDaoImpl();
		User user = new User();
		user.setName("zhangsan");
		user.setAge(112);
		userDao.addUser(user);
	}

	@Test
	public void testGetUserById00() {
		UserDao userDao = new UserDaoImpl();
		User user = userDao.getUserById(123l);
		System.out.println(user);
	}

	@Test
	public void testLoadUserById00() {
		UserDao userDao = new UserDaoImpl();
		User user = userDao.loadUserById(1222l);
		System.out.println(user);
	}
	
	@Test
	public void testFindAllUser00() {
		UserDao userDao = new UserDaoImpl();
		List<User> result = userDao.findAllUser();
		System.out.println(result);
	}
}
