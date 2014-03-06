package com.shopping.service;

import com.shopping.entity.User;

public interface UsersManager {
	/*
	 * 用户登录功能
	 * */
	public User usersLogin(User users);
	/*
	 * 用户注册功能
	 * */
	public User usersRegister(User users);

}
