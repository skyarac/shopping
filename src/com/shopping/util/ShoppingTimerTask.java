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
	
	private ServletContext application=null;

	@Override
	public void run() {
		//查询热点类别的推荐商品
		List<List<Goods>> bigList = new ArrayList<List<Goods>>();
		// 查询出最多4个热点类别
		for (Category category : categoryDaoImpl.getCategorys(true)) {  //查询热点类别
			List<Goods> goodss = goodsDaoImpl.queryGiscommendGoods(category.getCid());
		//	System.out.println(goodss.get(0).getCategory().getCtype());
			bigList.add(goodss);
		}
	
		//把大集合存储到app中
		application.setAttribute("bigList", bigList);
	}
	
	public ServletContext getApplication() {
		return application;
	}

	public void setApplication(ServletContext application) {
		this.application = application;
	}

}
