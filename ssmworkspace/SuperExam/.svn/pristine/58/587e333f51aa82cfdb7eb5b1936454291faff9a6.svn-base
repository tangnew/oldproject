package com.gmm.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by JW.
 * User: JW
 * Date: Sep 27, 2016 
 * Time: 5:49:44 PM
 *
 * com.gmm.controller.UserControllerTest
 */
@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration({"classpath:spring/*.xml"})
public class UserControllerTest extends MockMvcRequestBuilders {

	  	@Autowired
	    private WebApplicationContext wac;

	    private MockMvc mockMvc;

	    @Before
	    public void setup() {
	        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	    }
	    
	    @Test
	    public void testIndex() throws Exception {
	        this.mockMvc.perform(get("/login/enter?id=xxx").accept(MediaType.parseMediaType("application/json;charset=UTF-8")));
	    }



}
