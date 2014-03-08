package com.shopping.web.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class UserAction {
	@RequestMapping("/index.do")
	public String index() {
		return "front/index";
	}
	
	@RequestMapping("/good_list.do")
	public String goodList() {
		return "front/good_list";
	}

	@RequestMapping("/good_detail.do")
	public String goodDetail() {
		return "front/good_detail";
	}

	@RequestMapping("/shop_cart.do")
	public String shopCart() {
		return "front/good_detail";
	}

	@RequestMapping("/contact.do")
	public String Contact() {
		return "front/contact";
	}

	@RequestMapping("/buy.do")
	public String buy() {
		return "front/buy";
	}
}
