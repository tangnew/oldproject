package com.army.building.controller;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.army.building.model.User;
import com.army.building.service.A;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application.xml" })
public class UserControllerTest {

	@Resource
	private ApplicationContext applicationContext;

	@Test
	public void testAdd() {
		System.out.println(applicationContext.getClass().getName());
		UserController userController = applicationContext.getBean(
				"userController", UserController.class);
		User user = applicationContext.getBean("user", User.class);
		user.setId(1);
		user.setName("zhangsan");
		userController.add(user);
	}

	@Test
	public void testUpdate() {
		System.out.println(applicationContext.getClass().getName());
		UserController userController = applicationContext.getBean(
				"userController", UserController.class);
		User user = applicationContext.getBean("user", User.class);
		user.setId(1);
		user.setName("zhangsan");
		userController.update(user);
	}

	@Test
	public void testDelete() {
		System.out.println(applicationContext.getClass().getName());
		UserController userController = applicationContext.getBean(
				"userController", UserController.class);
		User user = applicationContext.getBean("user", User.class);
		user.setId(1);
		user.setName("zhangsan");
		userController.delete(user);
	}
	
	@Test
	public void testException() {
		System.out.println(applicationContext.getClass().getName());
		UserController userController = applicationContext.getBean(
				"userController", UserController.class);
		userController.exception();
	}
	
	@Test 
	public void testDeclareParents() {
		System.out.println(applicationContext.getClass().getName());
		A userService = applicationContext.getBean(
				"userService", A.class);
		userService.say();
	}
}
