package com.proxy0;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.List;

public class ProxyChain {
	private List<? extends InvocationHandler> handlers;
	private int index = 0;

	public ProxyChain(List<? extends InvocationHandler> handlers) {
		this.handlers = handlers;
	}

	public void doFilter(ProxyChain chain) {
		if (index == handlers.size()) {
			return;
		}

		InvocationHandler invocationHandler = handlers.get(index);
		index++;

		RentHourseService rentHourseService = (RentHourseService) Proxy
				.newProxyInstance(RentHourseServiceImpl.class.getClassLoader(),
						RentHourseServiceImpl.class.getInterfaces(),
						invocationHandler);
		String result = rentHourseService.rentHouse("lisi", this);
		System.out.println(invocationHandler.getClass().getName()+"="+result);
	}
}
