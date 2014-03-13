package com.shopping.web.action.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class UserAction {

	@RequestMapping("/user_info.do")
	public String userInfo() {
		return "front/user_info";
	}

	@RequestMapping("/user_update.do")
	public String userUpdate() {
		return "front/user_update";
	}
	
	@RequestMapping("/register.do")
	public String userRegister() {
		return "front/user_register";
	}
	
	@RequestMapping("/user_login.do")
	public String userLogin() {
		return "front/user_login";
	}
	
	@RequestMapping("/shop_cart.do")
	public String shopCart() {
		return "shop_cart";
	}
	
	@RequestMapping("/contact.do")
	public String contact() {
		return "contact";
	}

}
