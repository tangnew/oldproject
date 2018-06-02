package com.factory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.modual.User;

public class FactoryTest {
	public static void main(String[] args) {
		BeanFactory bf = new ClassPathXmlApplicationContext("application.xml");
		
		System.out.println("=============静态工厂方法创建实例================");
		User user = bf.getBean("staticFactory", User.class);
		System.out.println(user.getId() + "=" + user.getName());
		System.out.println("=============实例工厂方法创建实例================");
		user = bf.getBean("staticInstanceFactoryBean", User.class);
		System.out.println(user.getId() + "=" + user.getName());
	}

}
