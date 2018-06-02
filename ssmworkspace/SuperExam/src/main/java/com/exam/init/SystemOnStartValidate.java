package com.exam.init;

import javax.annotation.Resource;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import com.exam.service.MenuService;

/**
 * Created by JW. 
 * User: JW 
 * Date: Nov 21, 2016 Time: 10:33:33 AM
 * 
 * sping初始化自动执行方式:
 * 
 * 第一种方式: 写一个类，实现BeanPostProcessor，这个接口bean后置接口有两个方法
 * （1）postProcessBeforeInitialization方法，在spring中定义的bean初始化前调用这个方法；
 * （2）postProcessAfterInitialization方法，在spring中定义的bean初始化后调用这个方法；
 * 这个虽然也能执行,但是是每次加载一个bean都会去执行,不太满足我的要求,我只需要一次就ok了,但是这个接口针对某个专门的bean有用
 * 
 * 第二种方式:实现ApplicationListener<ContextRefreshedEvent >
 * 
 * 第三种方式 :实现InitializingBean接口，在项目加载完毕后立刻执行afterPropertiesSet方法
 * ,并且可以使用spring注入好的bean。会污染代码。
 * 
 * 第四种方式:配置bean的init方法，不会污染代码 com.exam.service.StartValidateListenerService
 */
public class SystemOnStartValidate {

	@Resource(name="menuService")
	private MenuService menuService;

	public void init(){
		System.out.println("result:" + menuService.getAllMenus());
	}
	
}
 