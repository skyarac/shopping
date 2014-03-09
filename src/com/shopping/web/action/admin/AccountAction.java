package com.shopping.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shopping.entity.Account;

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

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String loginInput(HttpServletRequest request,
			HttpServletResponse response, String username, String password) {
		Account account = new Account();
		account.setAlogin(username);
		account.setApass(password);
		System.out.println("username=" + username + "   password=" + password);
		HttpSession session = request.getSession();
		session.setAttribute("account", account);
		return "redirect:index.do";
	}

	@RequestMapping(value = "/index.do")
	public String index() {
		return "index";
	}

}
