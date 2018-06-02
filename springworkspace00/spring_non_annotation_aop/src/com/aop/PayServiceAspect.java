package com.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class PayServiceAspect {
	public void before() {
		System.out.println("===before===");
	}

	public void after() {
		System.out.println("===after===");
	}

	public Object around(ProceedingJoinPoint pjp)
			throws Throwable {
		System.out.println("===========around before advice");
		String money = (String) pjp.proceed(new String[] { "repsslace" });
		System.out.println("===========around after advice");
		return money;
	}

	public void sayMoney(String money, String money1) {
		System.out.println("====" + this.getClass().getName() + "=" + money
				+ ";" + money1 + "====");
	}

	public void afterReturn(Object value) {
		System.out.println("===afterReturn===" + value);
	}

}
