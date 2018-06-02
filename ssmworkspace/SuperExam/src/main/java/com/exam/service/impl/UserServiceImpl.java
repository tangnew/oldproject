package com.exam.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.exam.dao.UserMapper;
import com.exam.entity.User;
import com.exam.service.UserService;

/**
 * Created by JW.
 * User: JW
 * Date: Nov 4, 2016 
 * Time: 5:11:10 PM
 *
 * com.exam.service.impl.UserServiceImpl
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	
	@Resource(name="userMapper")
	private UserMapper userMapper;
	
	@Override
	public User getUserByAccountId(String accountId) {
		return userMapper.selectUserByAccountId(accountId);
	}


	@Override
	public User updateUserByUser(User user) {
		userMapper.updateUserById(user);
		user = userMapper.selectUserById(user.getId());
		return user;
	}

}
