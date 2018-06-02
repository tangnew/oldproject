package com.tjj.bean.factory;

import java.util.HashMap;
import java.util.Map;

public class StaticFactory {

	private static Map<String, Car> map = new HashMap<String, Car>();
	static {
		map.put("car0", new Car());
		map.put("car1", new Car());
	}

	public static Car getCar(String beanName) {
		return map.get(beanName);
	}
}
