package com.army.building.life;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 1,调用Bean的构造函数(或者工厂方法)实例化Bean. 2,对Bean的成员变量赋值.
 * 3,如果Bean实现了BeanNameAware,调用Bean的setBeanName方法.
 * 4,如果Bean实现了BeanFactoryAware,调用Bean的setBeanFactory方法.
 * 5,如果Bean实现了ApplicationContextAware,调用Bean的setApplicationContext方法.
 * 6,如果容器中配置了BeanPostProcessor,调用BeanPostProcessor的
 * postProcessBeforeInitialization方法(如果有多个BeanPostProcessor,调用每一个
 * BeanPostProcessor的postProcessBeforeInitialization方法).
 * 6,如果Bean实现了InitializingBean,调用Bean的afterPropertiesSet方法.
 * 7,如果Bean配置了init-method方法,调用init-method配置的Bean方法.
 * 8,如果容器中配置了BeanPostProcessor,调用BeanPostProcessor的
 * postProcessAfterInitialization方法.(如果有多个BeanPostProcessor,调用每一个
 * BeanPostProcessor的postProcessAfterInitialization方法). 9,Bean处于可以使用的状态.
 * 10,Spring容器关闭. 11,4,如果Bean实现了DisposableBean,调用Bean的destroy方法.
 * 12,如果Bean配置了destroy-method方法,调用destroy-method配置的Bean的方法
 * 
 * @author Administrator
 * 
 */
public class TestAware implements InitializingBean, ApplicationContextAware,
		BeanFactoryAware, BeanNameAware,DisposableBean {

	public void init() {
		System.out.println("#### enter #####init");
	}

	/*
	 * 只有当前bean调用
	 */
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		System.out
				.println("####ApplicationContextAware enter #####setApplicationContext");

	}

	/*
	 * 只有当前bean调用
	 */
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("####BeanFactoryAware enter #####setBeanFactory");

	}

	/*
	 * 只有当前bean调用
	 */
	public void setBeanName(String name) {
		System.out.println("####BeanNameAware enter #####setBeanName,name:"
				+ name);

	}

	/*
	 * 只有当前bean调用
	 */
	public void afterPropertiesSet() throws Exception {
		System.out
				.println("####InitializingBean enter #####afterPropertiesSet");
	}

	@Override
	public void destroy() throws Exception {
		System.out
		.println("####DisposableBean enter #####destroy");
		
	}

}
