package com.shopping.dao;

import java.util.List;

import com.shopping.entity.User;

public interface UserDao {
	
	/**
	 * @param users
	 * @return
	 * 保存用户
	 */
	public User save(User user);
	
	
	
	/**
	 * @param users
	 * @return
	 * 查询User
	 */
	public User get(String username, String password);
	/**
	 * @param username
	 * @return
	 * 根据用户名查询并返回用户
	 */
	public User get(String username) ;
	
	public User get(int uid);
	
	/**
	 * @param uid
	 * 根据uid删除用户
	 */
	
	public void delete(int uid);
	
	/**
	 * @return
	 * 得到所有用户
	 */
	public List<User> listAll();
	
	/**
	 * @param user
	 * 更新用户
	 */
	public void update(User user);
		
	
 
}
