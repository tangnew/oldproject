package com.army.building.service.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;


@Aspect
public class BeforeAop {
	public BeforeAop(){
		System.out.println("BeforeAop init......");
	}
	@Before("execution(* com.army.building.service.*.* (..))")
	public void before() {
		System.out.println("aop...");
	}
}
