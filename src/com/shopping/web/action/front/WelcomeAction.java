package com.shopping.web.action.front;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.entity.Category;
import com.shopping.entity.Goods;
import com.shopping.service.CategoryService;
import com.shopping.service.GoodsService;
import com.shopping.service.impl.CategoryServiceImpl;
import com.shopping.service.impl.GoodsServiceImpl;

@Controller
@RequestMapping("/index")
public class WelcomeAction {

	private CategoryService categoryService = new CategoryServiceImpl();
	private GoodsService goodsService = new GoodsServiceImpl();

	@RequestMapping("/index.do")
	public ModelAndView index(ModelAndView mv) {
		List<List<Goods>> bigList = new ArrayList<List<Goods>>();
		// 所有类别所对应的商品信息

		for (Category category : categoryService.listAll()) {

			List<Goods> goodss = goodsService
					.getGisopenGoods(category.getCid());
			if(goodss.size() == 0)
				continue;
			bigList.add(goodss);
		}

		mv.addObject("bigList", bigList);
		mv.setViewName("index");

		return mv;
	}

	@RequestMapping("/goods_list.do")
	public String goodsList() {
		return "goods_list";
	}

	@RequestMapping(value = "/goods_detail.do")
	public String goodsDetail() {
		return "goods_detail";
	}

	@RequestMapping("/contact.do")
	public String contact() {
		return "contact";
	}

	@RequestMapping("/buy.do")
	public String buy() {
		return "buy";
	}

}
