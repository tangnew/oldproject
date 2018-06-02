package com.mmn.service;

import javax.annotation.Resource;

import org.junit.Test;

import com.gmm.App;
import com.gmm.service.UserService;
import com.gmm.vo.UserVO;

/**
 * 
 * Created by JW.
 * User: JW
 * Date: Sep 26, 2016 
 * Time: 3:35:12 PM
 *
 * com.mmn.service.UserServiceTest
 */
public class UserServiceTest extends App {
	
	@Resource(name="userService")
	private UserService userService;
	
	@Test
	public void testCreateUser() {
		UserVO userVO = new UserVO();
		userVO.setLoginName("rg");
		userVO.setMobilePhone("1222222");
		userVO.setPassword("jw");
		userVO.setStatus(1);
		userVO.setEmail("jw@jw.com");
		userService.createUser(userVO);
	}
	
	@Test
	public void testDeleteUserById() {
		String id = "a1463439-bfd1-4675-aeae-963ecb320287";
		userService.deleteUserById(id);
	}

}
