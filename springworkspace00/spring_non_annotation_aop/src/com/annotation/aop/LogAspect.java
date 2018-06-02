package com.annotation.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAspect {

	@SuppressWarnings("unused")
	@Pointcut(value = "within(com.annotation.service.impl.PayServiceImpl)")
	private void before() {
	}

	@SuppressWarnings("unused")
	@Pointcut(value = "execution(* com.annotation.service.PayService.pay()) || execution(* com.annotation.service.PayService.savePay())")
	private void after() {
	}

	@SuppressWarnings("unused")
	@Pointcut(value = "execution(* com.annotation.service.PayService.payMoney(java.lang.String)) && args(money)", argNames = "money")
	private void money(String money) {
		System.out.println("=====money====="+money);
	}

	@Before(value = "before()")
	public void beforePay() {
		System.out.println("=======before pay=======");
	}

	@After(value = "after()")
	public void afterPay() {
		System.out.println("=======after pay=======");
	}

	@Before(value = "money(money)", argNames = "money")
	public void beforePayMoney(String money) {
		System.out.println("=======before pay money======="+money);
	}
}
