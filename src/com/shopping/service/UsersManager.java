package com.shopping.service;

import com.shopping.entity.User;

public interface UsersManager {
	/*
	 * �û���¼����
	 * */
	public User usersLogin(User users);
	/*
	 * �û�ע�Ṧ��
	 * */
	public User usersRegister(User users);

}
