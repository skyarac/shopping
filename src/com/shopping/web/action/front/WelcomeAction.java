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
	@RequestMapping(value="/goods_detail.do")
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
