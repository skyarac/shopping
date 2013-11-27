package com.shopping.dao;

import java.util.List;

import com.shopping.entity.Category;

public interface CategoryDao {
	/*
	 * �����Ʒ�����Ϣ
	 * */
	public void save(Category category);
	/*
	 * �����cidɾ����Ʒ�����Ϣ
	 * */
	public void delete(int cid);
	/*
	 * �������������Ϣ
	 * */
	public List<Category> getCategorys();
	/*
	 * ������������ַ����������Ϣ
	 * */
	public List<Category> getCategorys(String ctype);
	/*
	 * ����chot�����ȵ����
	 * */
	public List<Category> getCategorys(boolean isChot);
	/*
	 * �����µ������Ϣcategory�޸������Ϣ
	 * */
	public void categoryModify(Category category);

}
