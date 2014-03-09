package com.shopping.web.action.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class WelcomeAction {
	@RequestMapping("/index.do")
	public String index() {
		return "index";
	}

	

	

	@RequestMapping("/goods_list.do")
	public String goodsList() {
		return "goods_list";
	}

	public String goodsDetail() {
		return "goods_detail";
	}

	@RequestMapping("/buy.do")
	public String buy() {
		return "front/buy";
	}
}
