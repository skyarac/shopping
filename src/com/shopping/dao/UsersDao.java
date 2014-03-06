package com.shopping.dao;

import java.util.List;

import com.shopping.entity.User;

public interface UsersDao {
	/*ע��ʱ������û�*/
	public User save(User users);
	/*
	 * �����û���½��ulogin��ѯ�û��Ƿ����
	 * */
	public boolean checkUserExistsWithName(String username);
	/*
	 * ���ݴ�����û���ѯ�û�����������Ϣ
	 * */
	public User queryUsers(User users);
	/*
	 * �����û�uidɾ���û�
	 * */
	public void delete(int uid);
	/*
	 * ��ѯ�����û�
	 * */
	public List<User> getUsers();
	/*
	 * �����û���Ϣ��ǰ̨��װ�û�uid
	 * */
	public void usersModify(User users);
		
	
 
}
