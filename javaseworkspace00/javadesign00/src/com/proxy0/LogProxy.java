package com.proxy0;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogProxy implements InvocationHandler {

	private Object target;

	public LogProxy(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("log start");
		String result = (String)method.invoke(target, args);
		System.out.println("log:"+result);
		System.out.println("log end");
		return result;
	}

}
