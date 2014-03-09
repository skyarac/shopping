package com.shopping.service.impl;

import java.util.List;

import com.shopping.dao.CategoryDao;
import com.shopping.dao.impl.CategoryDaoImpl;
import com.shopping.entity.Category;
import com.shopping.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	private CategoryDao categoryDao = new CategoryDaoImpl();
	@Override
	public void save(Category category) {
		categoryDao.save(category);

	}

	@Override
	public void delete(int cid) {
		categoryDao.delete(cid);

	}

	@Override
	public List<Category> listAll() {
		return categoryDao.listAll();
	}

	@Override
	public List<Category> listByCtype(String ctype) {
		return categoryDao.listByCtype(ctype);
	}

	@Override
	public List<Category> listByChot(boolean isChot) {
		return categoryDao.listByChot(isChot);
	}

	@Override
	public void update(Category category) {
		categoryDao.update(category);
	}

	@Override
	public Category getCategoryById(int cid) {
		return categoryDao.get(cid);
	}

}
