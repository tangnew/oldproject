package com.tjj.spel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpelTest {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"spel.xml");
		Person p0 = applicationContext.getBean("p0", Person.class);
		System.out.println(p0.getUser());
	}
}
