package com.shopping.service.impl;

import java.util.List;

import com.shopping.dao.UserDao;
import com.shopping.dao.impl.UserDaoImpl;
import com.shopping.entity.User;
import com.shopping.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao = new UserDaoImpl();

	@Override
	public User login(String username, String password) {
		User u = userDao.get(username,password);
		return u;
	}

	@Override
	public User register(User user) {
		boolean exists = this.checkUserExistsWithName(user.getUlogin());
		if(exists){
			return null;
		} else {
			User u = userDao.save(user);
			return u;
		}
		
	}

	/**
	 * @param username
	 * @return 根据用户名 检查用户是否存在
	 */
	public boolean checkUserExistsWithName(String username) {
		User u = userDao.get(username);
		if(u != null) 
			return true;
		return false;
	}

	@Override
	public void modify(User user) {
		userDao.update(user);
	}

	@Override
	public List<User> listAll() {
		
		return userDao.listAll();
	}

	@Override
	public User getUserByName(String username) {
		
		return userDao.get(username);
	}

	@Override
	public User getUserById(int uid) {
		
		return userDao.get(uid);
	}

	@Override
	public void deleteById(int uid) {
		userDao.delete(uid);
		
	}

}
