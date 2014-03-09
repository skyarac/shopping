package com.shopping.web.action.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserAction {

	@RequestMapping("/user_info.do")
	public String userInfo() {
		return "front/user_info";
	}

	@RequestMapping("/user_update.do")
	public String userUpdate() {
		return "front/user_update";
	}

	

}
