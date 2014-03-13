package com.shopping.web.util;

import com.shopping.entity.Category;
import com.shopping.entity.Goods;
import com.shopping.service.CategoryService;
import com.shopping.service.GoodsService;
import com.shopping.service.impl.CategoryServiceImpl;
import com.shopping.service.impl.GoodsServiceImpl;

import javax.servlet.ServletContext;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class ShoppingTimerTask extends TimerTask {

	private CategoryService categoryService = new CategoryServiceImpl();

	private GoodsService goodsService = new GoodsServiceImpl();

	private ServletContext application = null;

	@Override
	public void run() {
		List<List<Goods>> bigList = new ArrayList<List<Goods>>();
		//取出热点类别热点商品
		for (Category category : categoryService.listByChot(true)) {
			List<Goods> goodss = goodsService.getGiscommendGoods(category
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
