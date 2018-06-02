package com.army.building.controller;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.army.building.model.User;

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

		User user1 = applicationContext.getBean("user", User.class);
		System.out.println("user == user1?" + (user1 == user));
		user1.setId(2);
		user1.setName("lisi");
		userController.add(user1);

	}
}
