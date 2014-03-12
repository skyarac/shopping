package com.shopping.web.action.admin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.entity.Category;
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
		
		 int gid = Integer.parseInt(request.getParameter("gid"));
		String gname = request.getParameter("gname");
		double gprice = Double.parseDouble(request.getParameter("gprice"));
		String gpic = request.getParameter("gpic");
		String gremark = request.getParameter("gremark");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
		Date gdate = null;
		try {
			gdate = sdf.parse(request.getParameter("gdate"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String gxremark = request.getParameter("gxremark");
		boolean giscommend = Boolean.parseBoolean(request.getParameter("giscommend"));
		boolean gisopen = Boolean.parseBoolean(request.getParameter("gisopen"));
		int cid = Integer.parseInt(request.getParameter("cid"));
		
		Goods goods = new Goods();
		Category category = new Category();
		category.setCid(cid);
		goods.setCategory(category);
		goods.setGdate(gdate);
		goods.setGid(gid);
		goods.setGiscommend(giscommend);
		goods.setGisopen(gisopen);
		goods.setGname(gname);
		goods.setGpic(gpic);
		goods.setGprice(gprice);
		goods.setGremark(gremark);
		goods.setGxremark(gxremark);
		goodsService.update(goods);
		return "redirect:goods_list.do";
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
