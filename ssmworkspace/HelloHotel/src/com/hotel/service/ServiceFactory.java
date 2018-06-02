package com.hotel.service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JW.
 * User: JW
 * Date: Dec 26, 2016 
 * Time: 5:57:44 PM
 *
 * com.hotel.service.ServiceFactory
 */
public class ServiceFactory {
	public static final String HOUSE_SERIVCE = HouseService.class
			.getSimpleName();
	public static final String HOUSE_TYPE_SERVICE = HouseTypeService.class
			.getSimpleName();
	public static final String CLIENT_HOUSE_SERIVCE = ClientHouseService.class
			.getSimpleName();

	private static Map<String, Object> cache = new HashMap<String, Object>();

	public static void addService(String serviceName, Object service) {
		if (null == cache.get(serviceName)) {
			cache.put(serviceName, service);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T getService(String serviceName) {
		return (T) cache.get(serviceName);
	}
}
