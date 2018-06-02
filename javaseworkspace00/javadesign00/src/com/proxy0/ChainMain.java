package com.proxy0;

import java.lang.reflect.InvocationHandler;
import java.util.ArrayList;
import java.util.List;

public class ChainMain {
	public static void main(String[] args) {
		RentHourseService target = new RentHourseServiceImpl();
		InvocationHandler acceptMoneyProxy = new AcceptMoneyProxy(target);
		InvocationHandler logProxy = new LogProxy(target);
		List<InvocationHandler> chain = new ArrayList<>();
		chain.add(logProxy);
		chain.add(acceptMoneyProxy);

		ProxyChain c = new ProxyChain(chain);
		c.doFilter(c);
	}
}
