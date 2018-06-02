package com.army.building.aop;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/app*.xml")
public class UserServiceTest {
	@Resource
	private ApplicationContext applicationContext;

	@Test
	public void testBefore() {
		UserService userService = applicationContext.getBean("userService",
				UserService.class);
		userService.add();
	}

	@Test
	public void testAround() {
		UserService userService = applicationContext.getBean("userService",
				UserService.class);
		userService.around();
	}

	@Test
	public void testReturns() {
		UserService userService = applicationContext.getBean("userService",
				UserService.class);
		User user = new User();
		user.setName("lisi");
		System.out.println(userService.returns(user));
	}

	@Test
	public void testExceptions() {
		UserService userService = applicationContext.getBean("userService",
				UserService.class);
		userService.exceptions();
	}

	@Test
	public void testAddUser() {
		UserService userService = applicationContext.getBean("userService",
				UserService.class);
		User user = new User();
		user.setName("lisi");
		userService.addUser(user);
	}

	@Test
	public void testDeclareParentsr() {
		UI userService = applicationContext.getBean("userService", UI.class);
		userService.say();
	}
}
