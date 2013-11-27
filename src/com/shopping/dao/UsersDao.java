package com.shopping.dao;

import java.util.List;

import com.shopping.entity.Users;

public interface UsersDao {
	/*ע��ʱ������û�*/
	public Users save(Users users);
	/*
	 * �����û���½��ulogin��ѯ�û��Ƿ����
	 * */
	public boolean checkUserExistsWithName(String username);
	/*
	 * ���ݴ�����û���ѯ�û�����������Ϣ
	 * */
	public Users queryUsers(Users users);
	/*
	 * �����û�uidɾ���û�
	 * */
	public void delete(int uid);
	/*
	 * ��ѯ�����û�
	 * */
	public List<Users> getUsers();
	/*
	 * �����û���Ϣ��ǰ̨��װ�û�uid
	 * */
	public void usersModify(Users users);
		
	
 
}
