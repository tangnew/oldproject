package com.service.product;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.model.product.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application*.xml" })
public class ProductServiceTest0 {

	@Resource(name = "productService")
	private ProductService productService;

	@Test
	public void testSave0() {
		Product p = new Product();
		p.setName("d");
		p.setDescription("test");
		Date now = new Date();
		p.setCreatedTime(now);
		p.setUpdatedTime(now);
		p.setStatus(4L);
		productService.save(p);
	}
}
