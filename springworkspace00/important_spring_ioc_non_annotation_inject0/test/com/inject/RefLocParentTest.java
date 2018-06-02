package com.inject;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RefLocParentTest {
	@Test
	public void testInject0() {
		// 初始化父容器
		ApplicationContext acp = new ClassPathXmlApplicationContext(
				"parent.xml");
		// 初始化当前容器
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[] { "local.xml" }, acp);
		System.out
				.println("======<ref local=””/>配置方式：用于引用通过<bean id=”beanName”>方式中通过id属性指定的Bean，它能利用XML解析器的验证功能在读取配置文件时来验证引用的Bean是否存在。因此如果在当前配置文件中有相互引用的Bean可以采用<ref local>方式从而如果配置错误能在开发调试时就发现错误。=======");
		RefLocParent rS = ac.getBean("recLoc", RefLocParent.class);
		System.out.println(rS.getObject().getName());
		System.out
				.println("=======2）<ref parent=””/>配置方式：用于引用父容器中的Bean，不会引用当前容器中的Bean，当然父容器中的Bean和当前容器的Bean是可以重名的，获取顺序是先查找当前容器中的Bean，如果找不到再从父容器找======");
		rS = ac.getBean("recParent", RefLocParent.class);
		System.out.println(rS.getObject().getName());
		System.out.println("=======内部bean：不能够被其他bean引用=======");
		rS = ac.getBean("inlineBean", RefLocParent.class);
		System.out.println(rS.getObject().getName());
		System.out.println("=======nullBean=======");
		rS = ac.getBean("nullBean", RefLocParent.class);
		System.out.println(rS.getName());
	}
}
