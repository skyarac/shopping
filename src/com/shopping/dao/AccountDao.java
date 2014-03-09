package com.shopping.dao;

import java.util.List;

import com.shopping.entity.Account;

public interface AccountDao {

	/**
	 * @param account
	 * 添加客服
	 */
	public void save(Account account);

	/**
	 * @param aid
	 * 根据客服id删除客服
	 */
	public void delete(String aid);
	
	/**
	 * @return
	 * 查询并返回所有客服
	 */
	public List<Account> listAll();
	
	/**
	 * @param account
	 * 更新客服
	 */
	public void update(Account account);
	
	/**
	 * @param name
	 * @param password
	 * @return
	 * 根据用户名和密码查询并返回客服
	 */
	public Account get(String name,String password);
	
	/**
	 * @param aid
	 * @return
	 * 根据客服编号返回客服信息
	 */
	public Account get(int aid);

}
