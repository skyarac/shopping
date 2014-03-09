package com.shopping.service;

import java.util.List;

import org.junit.Test;

import com.shopping.entity.User;
import com.shopping.service.impl.UserServiceImpl;

public class UserServiceTest {
	@Test
	public void testLogin() {
		User u = null;
		UserService userSerice = new UserServiceImpl();
		u= userSerice.login("huawei", "huawei");
		if(u == null) {
			System.out.println("登录失败");
		} else {
			System.out.println(u.getUaddress());
		}
	}
	
	@Test
	public void testRegister() {
		UserService userSerice = new UserServiceImpl();
		User u = new User();
		u.setUaddress("西安");
		u.setUemail("admin@admin.com");
		u.setUlogin("xian2");
		u.setUname("西安");
		u.setUpass("xian");
		u.setUphone("1234567890");
		u.setUpost("441200");
		u.setUsex("male");
		User u1 = userSerice.register(u);
		if(u1 == null) {
			System.out.println("注册失败");
		} else {
			System.out.println("注册成功");
		}
		
	}
	@Test
	public void testModify() {
		UserService userSerice = new UserServiceImpl();
		User u = new User();
		u.setUid(1);
		u.setUaddress("西安");
		u.setUemail("admin@admin.com");
		u.setUlogin("xian2");
		u.setUname("西安");
		u.setUpass("xian");
		u.setUphone("1234567890");
		u.setUpost("441200");
		u.setUsex("male");
		userSerice.modify(u);
	}
	
	@Test
	public void testListAll() {
		UserService userService = new UserServiceImpl();
		List<User> lists = userService.listAll();
		System.out.println(lists.size());
	}
	
	@Test
	public void testGetUserByName() {
		UserService userService = new UserServiceImpl();
		User u = userService.getUserByName("wangge");
		System.out.println(u.getUaddress());
	}
	@Test 
	public void testGetUserById() {
		UserService userService = new UserServiceImpl();
		User u = userService.getUserById(1);
		System.out.println(u.getUemail());
	}
	
	@Test
	public void testDeleteById() {
		UserService userService = new UserServiceImpl();
		userService.deleteById(1);
	}
}
