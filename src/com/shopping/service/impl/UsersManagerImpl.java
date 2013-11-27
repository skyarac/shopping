package com.shopping.service.impl;

import com.shopping.dao.UsersDao;
import com.shopping.dao.impl.UsersDaoImpl;
import com.shopping.entity.Users;
import com.shopping.service.UsersManager;

public class UsersManagerImpl implements UsersManager {
/*
 * �û���¼���ܣ����ж��û��Ƿ����
 * */
	UsersDao usersDao=new UsersDaoImpl();
	Users users=null;
	public Users usersLogin(Users users) {
		users=usersDao.queryUsers(users);
		return users;
		
		
	}
	/*
	 * �û�ע�Ṧ��
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
