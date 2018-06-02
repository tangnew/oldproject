package com.service;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.impl.UserServiceImpl0;

public class TestUserService {
	@Test
	public void testAdd() {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(
				"application.xml");
		UserService us0 = beanFactory.getBean("userServiceImpl0",
				UserServiceImpl0.class);
		us0.add(null);
		UserService us1 = beanFactory.getBean("userServiceImpl0",
				UserServiceImpl0.class);
		System.out.println(us1 == us0);

	}
}
