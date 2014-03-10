package com.shopping.web.action.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.entity.Account;
import com.shopping.entity.User;
import com.shopping.service.AccountService;
import com.shopping.service.UserService;
import com.shopping.service.impl.AccountServiceImpl;
import com.shopping.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/account")
public class AccountAction {
	private AccountService accountService = new AccountServiceImpl();
	private UserService userService = new UserServiceImpl();

	@RequestMapping("/account_list.do")
	public String accountList() {
		return "account/account_list";
	}

	@RequestMapping("/account_modify.do")
	public String accountModify() {
		return "account/account_modify";
	}

	@RequestMapping("/user_list.do")
	public String userList(HttpServletRequest request) {
		List<User> users= userService.listAll();
		request.getSession().setAttribute("users", users);
		return "member/user_list";
	}

	@RequestMapping(value="/user_modify.do",method=RequestMethod.GET)
	public ModelAndView userModify(HttpServletRequest request,ModelAndView mv) {
		int uid = Integer.parseInt(request.getParameter("uid"));
		User u = userService.getUserById(uid);
		mv.addObject("user", u);
		mv.setViewName("member/user_modify");
		return mv;
	}
	@RequestMapping(value="/user_modify.do",method=RequestMethod.POST)
	public String ModifyUser(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String realname = request.getParameter("realname");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String postcode = request.getParameter("postcode");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		User user = new User();
		user.setUaddress(address);
		user.setUemail(email);
		user.setUid(id);
		user.setUlogin(username);
		user.setUname(realname);
		user.setUpass(password);
		user.setUphone(phone);
		user.setUpost(postcode);
		user.setUsex(gender);
		
		userService.modify(user);
		
		return "redirect:user_list.do";
	}
	@RequestMapping("/user_delete.do")
	public String userDelete(HttpServletRequest request) {
		int uid = Integer.parseInt(request.getParameter("uid"));
		userService.deleteById(uid);
		System.out.println("用户删除成功！");
		return "redirect:user_list.do";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login() {

		return "login";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String loginInput(HttpServletRequest request,
			HttpServletResponse response, String username, String password) {
		Account account = accountService.login(username, password);
		if (null == account) {
			return "login";
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("account", account);
			return "redirect:index.do";
		}
	}

	@RequestMapping(value = "/index.do")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/logout.do")
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute("account");
	
		return "login";
	}
}
