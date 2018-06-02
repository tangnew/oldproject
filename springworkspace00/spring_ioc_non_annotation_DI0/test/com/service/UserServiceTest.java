package com.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application.xml" })
public class UserServiceTest{

	@Autowired
	private ApplicationContext ap;
	@Resource(name = "uService0")
	private UserService userService;

	
	@Resource(name = "uService1")
	private UserService userService1;
	@Test
	public void testLazyInit() {
		userService.add(null);// 使用的时候才初始化构造方法, 然后执行init。
	}

	@Test
	public void testInitAndDestroy() {
		System.out.println(ap == null);
		userService.add(null);
	}

	@Test
	public void destroy() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"application.xml");
		// <!-- 要注册销毁回调，否则我们定义的销毁方法不执行.但是如果通过注解方式来配置的话,就不需要了 -->
		//context.registerShutdownHook();
		UserService u0 = context.getBean("uService0", UserService.class);
		u0.add(null);
	}
	
	@Test
	public void testDepend() {
		userService1.add(null);
	}
}
