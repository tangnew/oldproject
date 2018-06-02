package com.dynamic;

import java.lang.reflect.Proxy;

public class Main {
	public static void main(String[] args) {
		ProxyObject proxyObject = new ProxyObject(new RentHouseServiceImpl());
		RentHouseService rentHouseService = (RentHouseService) Proxy
				.newProxyInstance(proxyObject.getClass().getClassLoader(),
						RentHouseServiceImpl.class.getInterfaces(), proxyObject);
		System.out.println(rentHouseService.wantToRentHouse("成都武侯区"));
	}
}
