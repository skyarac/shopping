package com.shopping.web.action.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/goods")
public class GoodsAction {
	
	@RequestMapping("/goods_list.do")
	public String goodList() {
		return "goods/goodslist";
	}

	@RequestMapping("/goods_detail.do")
	public String goodDetail() {
		return "goods/goods_detail";
	}

	@RequestMapping("/goods_modify.do")
	public String goodModify() {
		return "goods/goods_modify";
	}

}
