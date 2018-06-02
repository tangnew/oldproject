package com.inject;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.modual.User;

public class UserTest {
	@Test
	public void testInject0() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"application.xml");
		System.out.println("=======构造方法注入 by index======");
		User us0 = ac.getBean("user0", User.class);
		System.out.println(us0.getId() + "=" + us0.getName());
		System.out.println("=======构造方法注入 by type======");
		us0 = ac.getBean("user1", User.class);
		System.out.println(us0.getId() + "=" + us0.getName());
		System.out.println("=======构造方法注入 by name======");
		us0 = ac.getBean("user2", User.class);
		System.out.println(us0.getId() + "=" + us0.getName());
		System.out.println("=======setter方法注入======");
		us0 = ac.getBean("user3", User.class);
		System.out.println(us0.getId() + "=" + us0.getName() + ";"
				+ us0.getAddresses() + ";" + us0.getMap());
		System.out.println("=======注入isBoolaen======");
		us0 = ac.getBean("user4", User.class);
		System.out.println(us0.isSuccess());
		System.out.println("=======注入常量 idref的bean与local区别======");
		us0 = ac.getBean("user5", User.class);
		System.out.println(us0.getName());
		try {
			us0 = ac.getBean("user6", User.class);
			System.out.println(us0.getName());
		} catch (Exception e) {
		}
		
	}
}
