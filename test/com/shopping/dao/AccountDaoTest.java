package com.shopping.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.shopping.dao.impl.AccountDaoImpl;
import com.shopping.entity.Account;

public class AccountDaoTest {

	@Test
	public void testSave() {
		Account account=new Account();
		account.setAid("daniel");
		account.setAlogin("daniel");
		account.setAname("µ¤Äá¶û");
		account.setApass("daniel");
		AccountDao accountDaoTest=new AccountDaoImpl();
		accountDaoTest.save(account);
	}
	@Test
	public void testDelete(){
		AccountDao accountDaoTest=new AccountDaoImpl();
		accountDaoTest.delete("daniel");
	}
	@Test
	public void testGetAccounts(){
		List<Account> accounts=new ArrayList<Account>();
		Account account=null;
		AccountDao accountDaoTest=new AccountDaoImpl();
		accounts=accountDaoTest.getAccounts();
		Iterator it=accounts.iterator();
		while(it.hasNext()){
			account=(Account)it.next();
			System.out.println(account.getAid());
			System.out.println(account.getAlogin());
			System.out.println(account.getAname());
			System.out.println(account.getApass());
			System.out.println("--------------------------");
		}
		
	}
	@Test
	public void testAccountModify(){
		Account account=new Account();
		account.setAlogin("king");
		account.setAname("½ðÏÈÉú");
		account.setApass("king");
		AccountDao accountDao=new AccountDaoImpl();
		accountDao.accountModify(account);
		
	}

}
