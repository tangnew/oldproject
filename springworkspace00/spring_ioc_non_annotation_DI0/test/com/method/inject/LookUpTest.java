package com.method.inject;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 所谓方法注入其实就是通过配置方式覆盖或拦截指定的方法，通常通过代理模式实现。Spring提供两种方法注入：查找方法注入和方法替换注入。
 * 
 * 
 * 1.首先“helloApi1”是“singleton”，通过setter注入的“printer”是“prototypePrinter”，所以它应该输出“
 * setter printer:0”和“setter
 * printer:1”；而“createPrototypePrinter”方法注入了“prototypePrinter
 * ”，所以应该输出两次“prototype
 * printer:0”；而“createSingletonPrinter”注入了“singletonPrinter”，所以应该输出“singleton
 * printer:0”和“singleton printer:1”。
 * 
 * 首先“helloApi2”是“prototype”，通过setter注入的“printer”是“prototypePrinter”，所以它应该输出两次“
 * setter printer:0”；而“createPrototypePrinter”方法注入了“prototypePrinter”，所以应该输出两次“
 * prototype
 * printer:0”；而“createSingletonPrinter”注入了“singletonPrinter”，所以应该输出“singleton
 * printer:2”和“singleton printer:3”。
 * 大家是否注意到“createSingletonPrinter”方法应该输出“该方法不会被执行
 * ，如果输出就错了”，而实际是没输出的，这说明Spring拦截了该方法并使用注入的Bean替换了返回结果。
 * 方法注入主要用于处理“singleton”作用域的Bean需要其他作用域的Bean时
 * ，采用Spring查找方法注入方式无需修改任何代码即能获取需要的其他作用域的Bean。
 * 
 * 2.替换方法注入
 * 也叫“MethodReplacer”注入，和查找注入方法不一样的是，他主要用来替换方法体。通过首先定义一个MethodReplacer接口实现
 * ，然后如下配置来实现
 * 
 * @author Administrator
 * 
 */
public class LookUpTest {
	@Test
	public void testLookup() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"application.xml");
		System.out.println("查找方法注入");
		System.out.println("=======singleton sayHello======");
		LookupI helloApi1 = context.getBean("helloApi1", LookupI.class);
		helloApi1.sayHello();
		helloApi1 = context.getBean("helloApi1", LookupI.class);
		helloApi1.sayHello();
		System.out.println("=======prototype sayHello======");
		LookupI helloApi2 = context.getBean("helloApi2", LookupI.class);
		helloApi2.sayHello();
		helloApi2 = context.getBean("helloApi2", LookupI.class);
		helloApi2.sayHello();
	}

	@Test
	public void testMethodReplacer() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"application.xml");
		Printer printer = context.getBean("printer", Printer.class);
		printer.print("我将被替换");
	}
}
