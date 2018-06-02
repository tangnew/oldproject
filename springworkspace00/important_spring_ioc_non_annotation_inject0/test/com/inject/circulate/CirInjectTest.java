package com.inject.circulate;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 循环调用是无法解决:就是说一个对象A的a方法了调用另外一个对象B的方法b，而B对象同时也引用了A对象，并且B对象中的方法b又调用A对象的a方法
 */
public class CirInjectTest {

	@Test
	public void testCirConstructorInject() throws Throwable {
		System.out.println("	<!-- 构造器循环依赖是无法解决 -->");
		try {
			ClassPathXmlApplicationContext ap = new ClassPathXmlApplicationContext();
			ap.setConfigLocation("cirinject.xml");
		} catch (Exception e) {
			e.printStackTrace();
			// 因为要在创建circle3时抛出；
			Throwable e1 = e.getCause().getCause().getCause();
			throw e1;
		}
	}

	@Test
	public void testCirSetInjectBySingleton() throws Throwable {
		System.out.println("set循环依赖只能解决单例作用域的Bean循环依赖");
		ClassPathXmlApplicationContext ap = new ClassPathXmlApplicationContext();
		try {
			ap.setAllowCircularReferences(true);// 禁用循环引用
			ap.setConfigLocation("cirinject.xml");
			ap.refresh();

		} catch (Exception e) {
			e.printStackTrace();
			// 因为要在创建circle3时抛出；
			Throwable e1 = e.getCause().getCause().getCause();
			throw e1;
		}

		CirA cirA = ap.getBean("cirAcall", CirA.class);
		System.out.println(cirA.getName());
	}

	@Test
	public void testCirSetInjectByProtoType() throws Throwable {
		System.out
				.println("	<!-- set循环依赖对prototype作用域的Bean循环依赖：对于“prototype”作用域Bean，"
						+ "Spring容器无法完成依赖注入，因为“prototype”作用域的Bean，Spring容器不进行缓存，因此无法提前暴露一个创建中的Bean。 -->");
		ClassPathXmlApplicationContext ap = new ClassPathXmlApplicationContext();
		try {
			ap.setAllowCircularReferences(true);// 禁用循环引用
			ap.setConfigLocation("cirinject.xml");
			ap.refresh();
		} catch (Exception e) {
			e.printStackTrace();
			// 因为要在创建circle3时抛出；
			Throwable e1 = e.getCause().getCause().getCause();
			throw e1;
		}

		CirA cirA = ap.getBean("cirAcall", CirA.class);
		System.out.println(cirA.getName());
	}
}
