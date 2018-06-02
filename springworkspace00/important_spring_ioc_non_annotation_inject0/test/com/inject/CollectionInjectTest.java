package com.inject;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionInjectTest {
	@Test
	public void testCollectionInject() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"application.xml");
		System.out.println("=======collection注入 ======");
		CollectionInject collectionInject = ac.getBean("collectionInject",
				CollectionInject.class);
		System.out.println(collectionInject.getList() + ";"
				+ collectionInject.getMap() + ";" + collectionInject.getSet()
				+ ";" + Arrays.asList(collectionInject.getArray()) + ";"
				+ collectionInject.getProps());
	}
}
