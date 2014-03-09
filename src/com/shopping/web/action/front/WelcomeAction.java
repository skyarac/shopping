package com.shopping.web.action.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class WelcomeAction {
	@RequestMapping("/index.do")
	public String index() {
		return "front/index";
	}

	@RequestMapping("/contact.do")
	public String contact() {
		return "front/contact";
	}

	@RequestMapping("/shop_cart.do")
	public String shopCart() {
		return "front/shop_cart";
	}

	@RequestMapping("/goods_list.do")
	public String goodsList() {
		return "front/goods_list";
	}

	public String goodsDetail() {
		return "front/goods_detail";
	}

	@RequestMapping("/buy.do")
	public String buy() {
		return "front/buy";
	}
}
