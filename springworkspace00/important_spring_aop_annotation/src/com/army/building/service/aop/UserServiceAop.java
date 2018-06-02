package com.army.building.service.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.army.building.model.User;

@Component
@Aspect
public class UserServiceAop {
	public UserServiceAop(){
		System.out.println("init......");
	}
	@Before("execution(* com.army.building.service.UserService.add (..)) && args(user)")
	public void before(User user) {
		System.out.println(".....aop before....." + user.getName());
	}

	@After("execution(* com.army.building.service.UserService.add (..))")
	public void after() {
		System.out.println(".....aop after.....");
	}

	@Around("execution(* com.army.building.service.UserService.add (..))")
	public void around(ProceedingJoinPoint j) {
		System.out.println(".....aop around.....");
		try {
			j.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@AfterReturning(value = "execution(* com.army.building.service.UserService.update (..))", argNames = "user", returning = "user")
	public Object afterReturning(Object user) {
		((User) (user)).setName("lisi");
		System.out.println(".....aop AfterReturning.....");
		return user;
	}

	@AfterThrowing(value = "execution(* com.army.building.service.UserService.exceptions (..))", argNames = "exception", throwing = "exception")
	public void exception(Exception exception) {
		try {
			System.out.println("exception......" + exception);
		} catch (Exception e) {
		}
		System.out.println("after exception..........");
	}


	@After(value = "execution(* com.army.building.service.UserService.exceptions (..))")
	public void finallys() {
		System.out.println("after finallys..........");
	}
}
