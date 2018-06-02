package com.inject;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.modual.User;

public class FactoryTest {

	@Test
	public void testInject0() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"application.xml");
		System.out.println("=======静态工厂方法注入======");
		User us0 = ac.getBean("staticFactory", User.class);
		System.out.println(us0.getId() + "=" + us0.getName());
		System.out.println("=======实例工厂注入======");
		us0 = ac.getBean("factoryBeanInject", User.class);
		System.out.println(us0.getId() + "=" + us0.getName());
	}
}
