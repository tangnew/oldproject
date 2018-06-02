package com.proxy0;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AcceptMoneyProxy implements InvocationHandler {

	private Object target;

	public AcceptMoneyProxy(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("I want to accept money!");
		Object obj = method.invoke(target, args);
		System.out.println("accept money:"+obj);
		System.out.println("I have accepted money!");
		return obj;
	}

}
