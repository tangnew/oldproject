package com.army.building.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class UserAop {
	public void before() {
		System.out.println("aop before");
	}

	public void after() {
		System.out.println("aop after");
	}

	public void around(ProceedingJoinPoint p) {
		System.out.println("aop around");
		try {
			p.proceed();
		} catch (Throwable e) {
		}
	}

	public void returns(Object user) {
		System.out.println("aop returns:" + user + " " + user.hashCode());
		((User) user).setName("zhangsan1111");
	}

	public void exceptions(Exception exception) {
		System.out.println("aop exceptions:" + exception.getMessage());
	}
	
	public void beforeAddUser(User user){
		System.out.println("aop beforeAddUser:" + user.getName());
	}
	
	public void afterAddUser(User user){
		System.out.println("aop afterAddUser:" + user.getName());
		user.setName("ok");
	}
}
