package com.scope;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application.xml" })
public class ThreadScopeTest {

	@Test
	public void testThreaA() {
		ThreadA a = new ThreadA();
		a.start();
		Hello a1 = a.getHello();
		Hello b1 = a.getHello();
		System.out.println(a1 == b1);

		ThreadA b = new ThreadA();
		b.start();
		Hello b2 = b.getHello();
		System.out.println(a1 == b2);
	}

}
