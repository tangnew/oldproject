package com.scope;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ThreadA extends Thread {
	static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
			"application.xml");

	public ThreadA() {

	}

	private Hello hello;

	public Hello getHello() {
		return hello;
	}

	public void setHello(Hello hello) {
		this.hello = hello;
	}

	@Override
	public void run() {
		Hello a = context.getBean("hello0",Hello.class);
		Hello b = context.getBean("hello0",Hello.class);
		System.out.println(a == b);
		hello = a;
	}
}
