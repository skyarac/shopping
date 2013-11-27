package com.shopping.dao;

import java.util.List;

import com.shopping.entity.Users;

public interface UsersDao {
	/*注册时，添加用户*/
	public Users save(Users users);
	/*
	 * 根据用户登陆名ulogin查询用户是否存在
	 * */
	public boolean checkUserExistsWithName(String username);
	/*
	 * 根据传入的用户查询用户并返回用信息
	 * */
	public Users queryUsers(Users users);
	/*
	 * 根据用户uid删除用户
	 * */
	public void delete(int uid);
	/*
	 * 查询所有用户
	 * */
	public List<Users> getUsers();
	/*
	 * 更改用户信息，前台封装用户uid
	 * */
	public void usersModify(Users users);
		
	
 
}
