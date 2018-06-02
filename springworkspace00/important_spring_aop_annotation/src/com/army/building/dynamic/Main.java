package com.army.building.dynamic;

import java.lang.reflect.Proxy;

public class Main {
	public static void main(String[] args) {
		ProxyFactory p = new ProxyFactory();

		PayService ps = new PayServiceImpl();
		p.setTarget(ps);
		PayService ps1 = (PayService) Proxy.newProxyInstance(ps.getClass()
				.getClassLoader(), ps.getClass().getInterfaces(), p);
		ps1.pay(30);

		LoggingI logger = new Logging();
		p.setTarget(logger);
		LoggingI loggers = (LoggingI) Proxy.newProxyInstance(p.getClass()
				.getClassLoader(), logger.getClass().getInterfaces(), p);
		loggers.start();

		System.out.println("===========");
		Class[] a = new Class[logger.getClass().getInterfaces().length
				+ ps.getClass().getInterfaces().length];
		int i = 0;
		for (Class temp : logger.getClass().getInterfaces()) {
			a[i] = temp;
			i++;
		}

		for (Class temp : ps.getClass().getInterfaces()) {
			a[i] = temp;
			i++;
		}

		System.out.println(a.length);
		for (Class temp : a) {
			System.out.println(temp);
		}
		p.setTarget(ps);
		Object object = Proxy.newProxyInstance(p.getClass().getClassLoader(),
				a, p);

		PayService ps2 = (PayService) object;
		ps2.pay(60);
		p.setTarget(new Logging());
		LoggingI loggerI = (LoggingI) object;
		loggerI.start();

	}
}
