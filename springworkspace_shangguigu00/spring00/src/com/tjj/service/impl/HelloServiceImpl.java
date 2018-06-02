package com.tjj.service.impl;

import com.tjj.service.HelloService;

public class HelloServiceImpl implements HelloService {

	private String name;

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String sayHello() {
		String result = name + " say hello!";
		System.out.println(result);
		return result;
	}

}
