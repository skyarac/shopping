package com.shopping.service.impl;

import com.shopping.dao.UsersDao;
import com.shopping.dao.impl.UsersDaoImpl;
import com.shopping.entity.Users;
import com.shopping.service.UsersManager;

public class UsersManagerImpl implements UsersManager {
/*
 * 用户登录功能，先判断用户是否存在
 * */
	UsersDao usersDao=new UsersDaoImpl();
	Users users=null;
	public Users usersLogin(Users users) {
		users=usersDao.queryUsers(users);
		return users;
		
		
	}
	/*
	 * 用户注册功能
	 * */
	public Users usersRegister(Users users) {
		this.users=users;
		String ulogin=users.getUlogin();
		boolean isExist=usersDao.checkUserExistsWithName(ulogin);
		if(isExist){
			return null;
		}else{
			this.users=usersDao.save(users);
			return this.users;
		}
	}

}
