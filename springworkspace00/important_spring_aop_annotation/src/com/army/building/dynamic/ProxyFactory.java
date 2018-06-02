package com.army.building.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyFactory implements InvocationHandler {
	private Object target;

	public void setTarget(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("start ....");
		Object o = method.invoke(target, args);
		System.out.println("end...");
		return o;
	}

}
