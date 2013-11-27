package com.shopping.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.shopping.dao.impl.CategoryDaoImpl;
import com.shopping.entity.Account;
import com.shopping.entity.Category;

public class CategoryDaoTest {

	@Test
	public void testSave() {
		Category category=new Category();
		Account account=new Account();
		account.setAid("arac");
		category.setAccount(account);
		category.setChot(true);
		category.setCtype("文化用品");
		CategoryDao categoryDao=new CategoryDaoImpl();
		categoryDao.save(category);
	}
	@Test
	public void testDelete(){
		CategoryDao categoryDao=new CategoryDaoImpl();
		categoryDao.delete(9);
	}
	@Test
	public void testGetCategorys(){
		List<Category> categorys=new ArrayList<Category>();
		Category category=null;
		CategoryDao categoryDao=new CategoryDaoImpl();
		categorys=categoryDao.getCategorys("");
		Iterator it=categorys.iterator();
		while(it.hasNext()){
			category=(Category)it.next();
			System.out.println(category.getAccount().getAid());
			System.out.println(category.getChot());
			System.out.println(category.getCid());
			System.out.println(category.getCtype());
			System.out.println("----------------------");
		}
	}
	@Test
	public void testGetCategorys_By_Ctype(){
		List<Category> categorys=new ArrayList<Category>();
		Category category=null;
		CategoryDao categoryDao=new CategoryDaoImpl();
		String ctype="书";
		categorys=categoryDao.getCategorys(ctype);
		Iterator it=categorys.iterator();
		while(it.hasNext()){
			category=(Category)it.next();
			System.out.println(category.getAccount().getAid());
			System.out.println(category.getChot());
			System.out.println(category.getCid());
			System.out.println(category.getCtype());
			System.out.println("----------------------");
		}
	}
	@Test
	public void testGetCategory_By_Chot(){
		List<Category> categorys=new ArrayList<Category>();
		Category category=null;
		CategoryDao categoryDao=new CategoryDaoImpl();
		//String ctype="书";
		categorys=categoryDao.getCategorys(false);
		Iterator it=categorys.iterator();
		while(it.hasNext()){
			category=(Category)it.next();
			System.out.println(category.getAccount().getAid());
			System.out.println(category.getChot());
			System.out.println(category.getCid());
			System.out.println(category.getCtype());
			System.out.println("----------------------");
		}
	}
	@Test
	public void testCategoryModify(){
		Category category=new Category();
		Account account=new Account();
		account.setAid("tom");
		category.setAccount(account);
		category.setChot(true);
		category.setCid(4);
		category.setCtype("精品图书");
		CategoryDao categoryDao=new CategoryDaoImpl();
		categoryDao.categoryModify(category);
	}
}
