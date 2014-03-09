package com.shopping.web.action.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/forder")
public class ForderAction {
	@RequestMapping("/forder_list.do")
	public String forderList() {
		return "forder/forder_list";
	}
	
	@RequestMapping("/forder_modify.do")
	public String forderModify() {
		return "forder/forder_modify";
	}
}
