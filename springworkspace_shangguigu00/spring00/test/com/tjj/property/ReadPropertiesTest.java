package com.tjj.property;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ReadPropertiesTest {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"read_properties.xml");
		ReadProperties readProperties = applicationContext.getBean(
				"readProperties", ReadProperties.class);
		System.out.println(readProperties.getUser());
	}
}
