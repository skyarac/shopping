package com.shopping.service;

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
}
