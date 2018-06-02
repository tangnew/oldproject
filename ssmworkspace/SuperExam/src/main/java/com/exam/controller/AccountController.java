package com.exam.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exam.entity.Account;
import com.exam.manager.SessionManager;
import com.exam.service.AccountService;
import com.exam.vo.AccountVO;

/**
 * Created by JW.
 * User: JW
 * Date: Nov 4, 2016 
 * Time: 3:02:57 PM
 *
 * com.exam.controller.AccountController
 */
@Controller
@RequestMapping("/account")
public class AccountController {
	@Resource(name = "accountService")
	private AccountService accountService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public Account register(AccountVO accountVO) {
		accountService.createAccount(accountVO);
		return accountVO;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Account login(HttpServletRequest request, Account account) {
		account = accountService
				.getAccountByLoginNameAndPassword(account);
		if(null != account && null != account.getId()){
			SessionManager.setSession(request, SessionManager.USER, account);
		}
		return account;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	@ResponseBody
	public void logout(HttpServletRequest request) {
		SessionManager.invalidateSession(request);
	}
}
