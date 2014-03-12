package com.shopping.web.action.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.entity.Goods;
import com.shopping.service.GoodsService;
import com.shopping.service.impl.GoodsServiceImpl;

@Controller
@RequestMapping("/goods")
public class GoodsAction {
	private GoodsService goodsService = new GoodsServiceImpl();

	@RequestMapping("/goods_list.do")
	public ModelAndView goodList(HttpServletRequest requests, ModelAndView mv) {
		List<Goods> goodsList = goodsService.listAll();
		mv.addObject("goodsList", goodsList);
		mv.setViewName("goods/goods_list");
		return mv;
	}

	@RequestMapping("/goods_detail.do")
	public String goodDetail() {
		return "goods/goods_detail";
	}

	@RequestMapping(value = "/goods_modify.do", method = RequestMethod.POST)
	public String goodModify(HttpServletRequest request) {
		
		return "goods/goods_modify";
	}

	@RequestMapping(value = "/goods_modify.do", method = RequestMethod.GET)
	public ModelAndView ModifyGoods(HttpServletRequest request,ModelAndView mv ) {
		Integer id = Integer.parseInt(request.getParameter("gid").trim());
		Goods goods = goodsService.getGoodsByGid(id);
		mv.addObject("goods", goods);
		mv.setViewName("goods/goods_modify");
		return mv;
	}

}
