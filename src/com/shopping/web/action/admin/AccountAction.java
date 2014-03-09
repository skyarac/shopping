package com.shopping.web.action.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountAction {

	@RequestMapping("/account_list.do")
	public String accountList() {
		return "account/account_list";
	}

	@RequestMapping("/account_modify.do")
	public String accountModify() {
		return "account/account_modify";
	}

}
