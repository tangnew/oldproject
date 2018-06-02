package com.tjj.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tjj.bean.factory.Car;

public class HelloServiceTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		HelloService helloService = applicationContext.getBean("helloService",
				HelloService.class);
		String result = helloService.sayHello();
		System.out.println(applicationContext.isSingleton("helloService"));
		System.out.println(result);

		HelloService helloService3 = applicationContext.getBean(
				"helloService3", HelloService.class);
		helloService3.sayHello();
		
		 Car car0 = applicationContext.getBean(
					"staticFactory", Car.class);
		 System.out.println(car0.getName());
		((ClassPathXmlApplicationContext) applicationContext).close();
	}
}
