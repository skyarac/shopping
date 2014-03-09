package com.shopping.web.action.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserAction {

	/*@RequestMapping("/user_info.do")
	public String userInfo() {
		return "front/user_info";
	}

	@RequestMapping("/user_update.do")
	public String userUpdate() {
		return "front/user_update";
	}*/

	@RequestMapping("/user_list.do")
	public String userList() {
		return "member/user_list";
	}

	@RequestMapping("/user_modify.do")
	public String userModify() {
		return "member/user_modify";
	}

}
