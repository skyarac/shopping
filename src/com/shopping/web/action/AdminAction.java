package com.shopping.web.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminAction {
	@RequestMapping("/index.do")
	public String index() {
		return "admin/index";
	}
	
	@RequestMapping("/login.do")
	public String login() {
		return "admin/login";
	}
	@RequestMapping("/user_list.do")
	public String userList() {
		return "admin/user_list";
	}
}
