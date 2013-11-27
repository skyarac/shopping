package com.shopping.dao;

import java.util.List;

import com.shopping.entity.Category;

public interface CategoryDao {
	/*
	 * 添加商品类别信息
	 * */
	public void save(Category category);
	/*
	 * 按类别cid删除商品类别信息
	 * */
	public void delete(int cid);
	/*
	 * 返回所有类别信息
	 * */
	public List<Category> getCategorys();
	/*
	 * 根据类别名或字符返回类别信息
	 * */
	public List<Category> getCategorys(String ctype);
	/*
	 * 根据chot返回热点类别
	 * */
	public List<Category> getCategorys(boolean isChot);
	/*
	 * 根据新的类别信息category修改类别信息
	 * */
	public void categoryModify(Category category);

}
