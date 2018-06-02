package com.inject;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class NavigationTest {
	@Test
	public void testCollectionInject() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"navigation.xml");
		System.out.println("=======navigation注入 ======");
		Navigation navigation = ac.getBean("navigation", Navigation.class);
		System.out.println((navigation.getArrays() == null) + ";"
				+ (navigation.getList() == null) + ";"
				+ (navigation.getMaps() == null));
		System.out.println("=======navigations注入 ======");
		navigation = ac.getBean("navigations", Navigation.class);
		System.out.println(navigation.getList().get(0).getName() + ";"
				+ navigation.getMaps().get("key").getName());
		System.out.println("=======使用p：navigationsSimple注入 ======");
		navigation = ac.getBean("navigationsSimple", Navigation.class);
		System.out.println(navigation.getName());
	}
}
