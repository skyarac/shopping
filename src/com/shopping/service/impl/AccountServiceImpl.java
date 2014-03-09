package com.shopping.service.impl;

import com.shopping.dao.AccountDao;
import com.shopping.dao.impl.AccountDaoImpl;
import com.shopping.entity.Account;
import com.shopping.service.AccountService;

public class AccountServiceImpl implements AccountService {
	private AccountDao accountDao = new AccountDaoImpl();
	@Override
	public Account login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
