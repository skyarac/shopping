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
}