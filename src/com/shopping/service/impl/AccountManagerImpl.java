package com.shopping.service.impl;

import com.shopping.dao.AccountDao;
import com.shopping.dao.impl.AccountDaoImpl;
import com.shopping.entity.Account;
import com.shopping.service.AccountManager;

public class AccountManagerImpl implements AccountManager {
   Account account=null;
   AccountDao accountDao=new AccountDaoImpl();
	public Account AccountLogin(Account account) {
		account=accountDao.queryAccount(account);
		return account;
	}

}
