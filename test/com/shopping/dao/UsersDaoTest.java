package com.shopping.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import junit.framework.Assert;

import  org.junit.Assert.*;

import org.junit.Test;

import com.shopping.dao.impl.UsersDaoImpl;
import com.shopping.entity.Users;

public class UsersDaoTest {

	@Test
	public void testAddUsers() {
		Users users=new Users();
		users.setUaddress("湖北省襄阳市解放大道163号");
		users.setUemail("2285845368@qq.com");
		users.setUlogin("erick");
		users.setUname("erick");
		users.setUpass("erick");
		users.setUphone("15079688296");
		users.setUpost("345007");
		users.setUsex("男");
		UsersDao usersDao=new UsersDaoImpl();
		usersDao.save(users);
	}
	@Test
	public void testCheckUserExistsWithName(){
		String username="hello";
		UsersDao usersDao=new UsersDaoImpl();
		boolean check=usersDao.checkUserExistsWithName(username);
		Assert.assertEquals(true, check);
		
	}
	@Test
	public void testqueryUsers(){
		Users user=new Users();
		user.setUlogin("arac");
		user.setUpass("arac");
		UsersDao usersDao=new UsersDaoImpl();
		Users temp=usersDao.queryUsers(user);
		System.out.println(temp.getUaddress());
		System.out.println(temp.getUemail());
		System.out.println(temp.getUid());
		System.out.println(temp.getUlogin());
		System.out.println(temp.getUname());
		System.out.println(temp.getUpass());
		System.out.println(temp.getUphone());
		System.out.println(temp.getUpost());
		System.out.println(temp.getUsex());
	
	}
	@Test
	public void testDelete(){
		UsersDao usersDao=new UsersDaoImpl();
		usersDao.delete(7);
	}
	@Test
	public void testGetUsers(){
		List<Users> userList=new ArrayList();
		Users users=null;
		UsersDao usersDao=new UsersDaoImpl();
		userList=usersDao.getUsers();
		Iterator it=userList.iterator();
		while(it.hasNext()){
			users=(Users)it.next();
			System.out.println(users.getUname());
		}
	}
	@Test
	public void testUsersModify(){
		Users users=new Users();
		users.setUaddress("北京市朝阳区解放路11号");
		users.setUemail("2285845368@qq.com");
		users.setUid(8);
		users.setUlogin("eric");
		users.setUname("瑞可");
		users.setUpass("eric");
		users.setUphone("010-6780327");
		users.setUpost("100001");
		users.setUsex("男");
		UsersDao usersDao=new UsersDaoImpl();
		usersDao.usersModify(users);
		
	}

}
