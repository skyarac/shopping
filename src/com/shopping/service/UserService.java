package com.shopping.service;

import java.util.List;

import com.shopping.entity.User;

public interface UserService {
	/**
	 * @param user
	 * 用户登录
	 */
	public User login(String username, String password) ;
	
	/**
	 * @param user
	 * 用户注册
	 */
	public User register(User user);
	
	/**
	 * @param user
	 * @return
	 * 更新用户信息
	 */
	public void modify(User user);
	
	/**
	 * @return
	 * 获得所有用户信息
	 */
	public List<User> listAll();
	
	/**
	 * @param username
	 * @return
	 * 根据用户名获得用户
	 */
	public User getUserByName(String username);
	
	/**
	 * @param uid
	 * @return
	 * 根据用户id获取用户信息
	 */
	public User getUserById(int uid);
	/**
	 * @param uid
	 * 根据id删除用户
	 */
	public void deleteById(int uid);
}
