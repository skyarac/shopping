package com.shopping.dao;

import java.util.List;

import com.shopping.entity.User;

public interface UsersDao {
	/*注册时，添加用户*/
	public User save(User users);
	/*
	 * 根据用户登陆名ulogin查询用户是否存在
	 * */
	public boolean checkUserExistsWithName(String username);
	/*
	 * 根据传入的用户查询用户并返回用信息
	 * */
	public User queryUsers(User users);
	/*
	 * 根据用户uid删除用户
	 * */
	public void delete(int uid);
	/*
	 * 查询所有用户
	 * */
	public List<User> getUsers();
	/*
	 * 更改用户信息，前台封装用户uid
	 * */
	public void usersModify(User users);
		
	
 
}
