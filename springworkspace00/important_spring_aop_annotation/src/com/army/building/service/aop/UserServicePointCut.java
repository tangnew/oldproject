package com.army.building.service.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.army.building.model.User;
import com.army.building.service.A;
import com.army.building.service.AI;

@Component
@Aspect
public class UserServicePointCut {

	@Pointcut(value = "execution(* com.army.building.service.UserService.delete (..)) && args(user2,user3)")
	public void myPoint(User user2, User user3) {
	}

	@Before(value = "myPoint(user2,user3)", argNames = "user2,user3")
	// 如果第一个参数joinPoint的话，那么argNames可以省去
	public void before(JoinPoint jp, User user2, User user3) {
		System.out.println("myPoint:" + (User) (jp.getArgs()[0])
				+ user2.getName());
	}

	@After(value = "myPoint(user2,user3)")
	// 如果第一个参数joinPoint的话，那么argNames可以省去
	public void after(JoinPoint jp, User user2, User user3) {
		System.out.println("after myPoint:" + user3.getName());
	}

	// 引入：也称为内部类型声明，为已有的类添加额外新的字段或方法，Spring允许引入新的接口（必须对应一个实现）到所有被代理对象（目标对象）,
	// 在AOP中表示为“干什么（引入什么）”
	@DeclareParents(value = "com.army.building.service.UserService+", defaultImpl = AI.class)
	// 引入功能：（就是在运行时给某个接口的实现类同时实现另外一个接口）该注解必须运用到定指定需要引入的接口；
	public A myDeclareParents;

}
