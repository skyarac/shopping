package com.shopping.util;

import com.shopping.dao.CategoryDao;
import com.shopping.dao.GoodsDao;
import com.shopping.dao.impl.CategoryDaoImpl;
import com.shopping.dao.impl.GoodsDaoImpl;
import com.shopping.entity.Category;
import com.shopping.entity.Goods;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class ShoppingTimerTask extends TimerTask {

	private CategoryDao categoryDaoImpl = new CategoryDaoImpl();

	private GoodsDao goodsDaoImpl = new GoodsDaoImpl();

	private ServletContext application = null;

	@Override
	public void run() {
		List<List<Goods>> bigList = new ArrayList<List<Goods>>();

		for (Category category : categoryDaoImpl.getCategorys(true)) {
			List<Goods> goodss = goodsDaoImpl.queryGiscommendGoods(category
					.getCid());

			bigList.add(goodss);
		}

		application.setAttribute("bigList", bigList);
	}

	public ServletContext getApplication() {
		return application;
	}

	public void setApplication(ServletContext application) {
		this.application = application;
	}

}
