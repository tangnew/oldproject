package com.service.impl;

import com.service.HelloService;

public class HelloServiceImpl implements HelloService {

	@Override
	public void sayHello() {
		System.out.println("===========Hello World!");
	}

}
