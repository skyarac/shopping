package com.shopping.dao;

import java.util.List;

import com.shopping.entity.Account;

public interface AccountDao {
	/*
	 * ��ӿͷ�
	 * */
	public void save(Account account);
	/*
	 * ���տͷ�aid ɾ���ͷ�
	 * */
	public void delete(String aid);
	/*
	 * �������пͷ���Ϣ
	 * */
	public List<Account> getAccounts();
	/*
	 * ���ݴ���Ŀͷ��޸Ŀͷ���Ϣ
	 * */
	public void accountModify(Account account);
	/*
	 * ���ݴ���Ŀͷ���ϢAccount��ѯAccount
	 * */
	public Account queryAccount(Account account);

}
