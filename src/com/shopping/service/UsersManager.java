package com.shopping.service;

import com.shopping.entity.Users;

public interface UsersManager {
	/*
	 * �û���¼����
	 * */
	public Users usersLogin(Users users);
	/*
	 * �û�ע�Ṧ��
	 * */
	public Users usersRegister(Users users);

}
