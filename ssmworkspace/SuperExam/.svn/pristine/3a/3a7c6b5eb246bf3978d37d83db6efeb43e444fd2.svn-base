package com.exam.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.exam.dao.AccountMapper;
import com.exam.dao.UserMapper;
import com.exam.entity.Account;
import com.exam.entity.User;
import com.exam.service.AccountService;
import com.exam.utils.UuidUtil;
import com.exam.vo.AccountVO;

/**
 * Created by JW.
 * User: JW
 * Date: Nov 4, 2016 
 * Time: 3:35:25 PM
 *
 * com.exam.service.impl.AccountServiceImpl
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

	@Resource(name = "accountMapper")
	private AccountMapper accountMapper;
	
	@Resource(name="userMapper")
	private UserMapper userMapper;

	@Override
	public Account createAccount(AccountVO accountVO) {
		accountVO.setId(UuidUtil.getUUID());
		Date now = new Date();
		accountVO.setCreatedTime(now);
		accountVO.setUpdatedTime(now);

		accountMapper.insertAccount(accountVO);

		User user = new User();
		user.setId(UuidUtil.getUUID());
		user.setEmail(accountVO.getEmail());
		user.setName(accountVO.getLoginName());
		user.setFkAccountId(accountVO.getId());
		user.setCreatedTime(now);
		user.setUpdatedTime(now);
		user.setGender(true);
		userMapper.insertUser(user);
		return accountVO;
	}

	@Override
	public Account getAccountByLoginNameAndPassword(Account account) {
		account = accountMapper.getAccountByAccount(account);
		return account;
	}
}
