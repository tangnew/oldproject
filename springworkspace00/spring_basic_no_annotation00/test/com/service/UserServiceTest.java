package com.service;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.impl.UserServiceImpl0;
import com.service.impl.UserServiceImpl1;

public class UserServiceTest {
	@Test
	public void testAdd() {
		BeanFactory bf = new ClassPathXmlApplicationContext("application.xml");

		System.out.println("=============constructor-arg================");
		UserService us0 = bf.getBean("userService0", UserServiceImpl0.class);
		us0.add(null);
		us0.addDefault();
		System.out
				.println("=============init-method lazy-init================");
		UserService us1 = bf.getBean("userService1", UserServiceImpl1.class);
		us1 = null;
	}
}
