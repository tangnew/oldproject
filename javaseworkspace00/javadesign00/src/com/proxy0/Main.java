package com.proxy0;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Main {
	public static void main(String[] args) {
		RentHourseService target = new RentHourseServiceImpl();
		InvocationHandler acceptMoneyProxy = new AcceptMoneyProxy(target);
		InvocationHandler logProxy = new LogProxy(acceptMoneyProxy);
		
		RentHourseService rentHourseService = (RentHourseService) Proxy
				.newProxyInstance(RentHourseServiceImpl.class.getClassLoader(),
						RentHourseServiceImpl.class.getInterfaces(),
						logProxy);
		String name = "张三";
	//String result = rentHourseService.rentHouse(name,null);
//		System.out.println(result);
	}
}
