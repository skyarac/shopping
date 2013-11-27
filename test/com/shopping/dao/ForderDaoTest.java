package com.shopping.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.shopping.dao.impl.ForderDaoImpl;
import com.shopping.entity.Account;
import com.shopping.entity.Forder;
import com.shopping.entity.Goods;
import com.shopping.entity.Sorder;
import com.shopping.entity.Status;
import com.shopping.entity.Users;

public class ForderDaoTest {

	@Test
	public void testSaveForder() {
		List<Sorder> sorders=new ArrayList<Sorder>();
		Account account=new Account();
		Status status=new Status();
		Users users=new Users();
		users.setUid(2);
		Goods goods=new Goods();
		goods.setGid(1);
		Sorder sorder=new Sorder();
		sorder.setGoods(goods);
		sorder.setSid(1);
		sorder.setSname("²âÊÔ");
		sorder.setSnumber(1);
		sorder.setSprice(11.1);
		sorders.add(sorder);
		Forder forder=new Forder();
		forder.setFaddress("¾®´ó");
		forder.setFemail("100000@qq.com");
		forder.setFname("»ÆÏþÃ÷");
		forder.setFphone("10010");
		forder.setFpost("100000");
		forder.setFremark("good!");
		forder.setFtotal(11.1);
		forder.setSorders(sorders);
		forder.setUsers(users);
		forder.setAccount(account);
		forder.setStatus(status);
		ForderDao forderDao=new ForderDaoImpl();
		forder=forderDao.saveForder(forder);
		System.out.println(forder.getFid());
	}
	@Test
	public void testUpdateSorder(){
		List<Sorder> sorders=new ArrayList<Sorder>();
		Account account=new Account();
		Status status=new Status();
		Users users=new Users();
		users.setUid(2);
		Goods goods=new Goods();
		goods.setGid(1);
		Sorder sorder=new Sorder();
		sorder.setGoods(goods);
		sorder.setSid(1);
		sorder.setSname("²âÊÔ");
		sorder.setSnumber(1);
		sorder.setSprice(11.1);
		sorders.add(sorder);
		Forder forder=new Forder();
		forder.setFaddress("¾®´ó");
		forder.setFemail("100000@qq.com");
		forder.setFname("»ÆÏþÃ÷");
		forder.setFphone("10010");
		forder.setFpost("100000");
		forder.setFremark("good!");
		forder.setFtotal(11.1);
		forder.setSorders(sorders);
		forder.setUsers(users);
		forder.setAccount(account);
		forder.setStatus(status);
		ForderDao forderDao=new ForderDaoImpl();
	//	forder=forderDao.saveForder(forder);
		forder=forderDao.updateSorder(forder, 1, 2);
		System.out.println(forder.getSorders().get(0).getSnumber());
		
	}

}
