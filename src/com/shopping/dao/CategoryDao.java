package com.shopping.dao;

import java.util.List;

import com.shopping.entity.Category;

public interface CategoryDao {
	
	/**
	 * @param category
	 * 保存类别信息
	 */
	public void save(Category category);
	
	/**
	 * @param cid
	 * 根据cid删除类别
	 */
	public void delete(int cid);
	
	/**
	 * @return
	 * 返回所有类别信息
	 */
	public List<Category> listAll();
	
	/**
	 * @param ctype
	 * @return
	 * 根据类别名模糊查询并返回类别信息
	 */
	public List<Category> listByCtype(String ctype);
	
	/**
	 * @param isChot
	 * @return
	 * 根据是否热点查询并返回类别信息
	 */
	public List<Category> listByChot(boolean isChot);
	
	/**
	 * @param category
	 * 修改类别信息
	 */
	public void update(Category category);

}
