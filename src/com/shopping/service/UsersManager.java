package com.shopping.service;

import com.shopping.entity.Users;

public interface UsersManager {
	/*
	 * 用户登录功能
	 * */
	public Users usersLogin(Users users);
	/*
	 * 用户注册功能
	 * */
	public Users usersRegister(Users users);

}
