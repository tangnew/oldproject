package com.proxy0;

public class RentHourseServiceImpl implements RentHourseService {

	@Override
	public String rentHouse(String name, ProxyChain chain) {
		chain.doFilter(chain);
		return name + " rent house!";
	}

}
