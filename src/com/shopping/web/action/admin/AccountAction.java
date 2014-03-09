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

	@RequestMapping("/user_list.do")
	public String userList() {
		return "member/user_list";
	}

	@RequestMapping("/user_modify.do")
	public String userModify() {
		return "member/user_modify";
	}

}
