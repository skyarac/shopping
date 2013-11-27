package com.shopping.dao;

import java.util.List;

import com.shopping.entity.Account;

public interface AccountDao {
	/*
	 * 添加客服
	 * */
	public void save(Account account);
	/*
	 * 按照客服aid 删除客服
	 * */
	public void delete(String aid);
	/*
	 * 返回所有客服信息
	 * */
	public List<Account> getAccounts();
	/*
	 * 根据传入的客服修改客服信息
	 * */
	public void accountModify(Account account);
	/*
	 * 根据传入的客服信息Account查询Account
	 * */
	public Account queryAccount(Account account);

}
