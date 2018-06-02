package com.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.service.HelloService;
import com.service.PayService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application.xml" })
public class Main {
	@Resource(name = "helloService")
	private HelloService helloService;

	@Resource(name = "payService")
	private PayService payService;

	@Resource(name = "annotationPayService")
	private com.annotation.service.PayService annPayService;
	
	@Test
	public void testSayHello() {
		System.out.println(helloService.getClass().getName());
		helloService.sayHello();
	}

	@Test
	public void testPay() {
		//payService.pay();
		//payService.sayMoney("12","122");
		payService.getMoney("fadf");
	}
	
	@Test
	public void testAnnotationPay() {
		annPayService.pay();
		annPayService.savePay();
		annPayService.payMoney("222");
	}
	
}
