package com.shopping.web.action.front;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.entity.Category;
import com.shopping.entity.Goods;
import com.shopping.entity.User;
import com.shopping.service.CategoryService;
import com.shopping.service.GoodsService;
import com.shopping.service.UserService;
import com.shopping.service.impl.CategoryServiceImpl;
import com.shopping.service.impl.GoodsServiceImpl;
import com.shopping.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/index")
public class WelcomeAction {

	private CategoryService categoryService = new CategoryServiceImpl();
	private GoodsService goodsService = new GoodsServiceImpl();
	private UserService userService = new UserServiceImpl();

	@RequestMapping("/index.do")
	public ModelAndView index(ModelAndView mv) {
		List<List<Goods>> bigList = new ArrayList<List<Goods>>();
		// 所有类别所对应的商品信息

		for (Category category : categoryService.listAll()) {

			List<Goods> goodss = goodsService
					.getGisopenGoods(category.getCid());
			if (goodss.size() == 0)
				continue;
			bigList.add(goodss);
		}
		mv.addObject("bigList", bigList);
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping("/goods_list.do")
	public ModelAndView goodsList(HttpServletRequest request, ModelAndView mv) {
		int cid = Integer.parseInt(request.getParameter("cid"));
		List<Goods> goodss = goodsService.getGoodsByCid(cid);
		mv.addObject("goodss", goodss);
		mv.setViewName("goods_list");
		return mv;
	}

	@RequestMapping(value = "/goods_detail.do")
	public ModelAndView goodsDetail(HttpServletRequest request, ModelAndView mv) {
		int gid = Integer.parseInt(request.getParameter("gid"));
		Goods goods = goodsService.getGoodsByGid(gid);
		Category category = categoryService.getCategoryById(goods.getCategory()
				.getCid());
		List<Goods> goodss = goodsService.getGoodsByCid(goods.getCategory()
				.getCid());
		mv.addObject("category", category);
		mv.addObject("goods", goods);
		mv.addObject("goodss", goodss);
		mv.setViewName("goods_detail");

		return mv;
	}

	@RequestMapping("/contact.do")
	public String contact() {
		return "contact";
	}

	@RequestMapping("/buy.do")
	public String buy() {
		return "buy";
	}
	
	@RequestMapping("/shop_cart.do")
	public String cart() {
		
		return "shop_cart";
	}
	
	@RequestMapping(value="/member/user_info.do",method=RequestMethod.GET)
	public String userInfo() {
		return "user_info";
	}
	
	
	@RequestMapping(value="/member/user_register.do" ,method=RequestMethod.GET)
	public String userRegister() {
		
		return "user_register";
	}
	
	@RequestMapping(value="/member/user_register.do",method=RequestMethod.POST)
	public String Register(HttpServletRequest request) {
		User user = new User();
		user.setUaddress(request.getParameter("uaddress"));
		user.setUemail(request.getParameter("uemail"));
		user.setUlogin(request.getParameter("ulogin"));
		user.setUname(request.getParameter("uname"));
		user.setUpass(request.getParameter("upass"));
		user.setUpost(request.getParameter("upost"));
		user.setUphone(request.getParameter("uphone"));
		user.setUsex(request.getParameter("usex"));
		user = userService.register(user);
		return "redirect:/index/index.do";
	}
	
	@RequestMapping(value="/user_update.do",method=RequestMethod.GET)
	public String userUpdate() {
		return "user_update";
	}
	
	@RequestMapping(value="/user_update.do",method=RequestMethod.POST)
	public String updateUser() {
		
		return "redirect:/index/index.do";
	}
	
	@RequestMapping(value="/member/login.do",method=RequestMethod.GET)
	public String userLogin(HttpServletRequest request) {
		
		return "user_login";
	}
	
	@RequestMapping(value="/member/login.do",method=RequestMethod.POST)
	public String login(HttpServletRequest request) {
		String ulogin = request.getParameter("ulogin");
		String upass = request.getParameter("upass");
		User user = userService.login(ulogin, upass);
		if(null != user) {
			request.getSession().setAttribute("user", user);
		}
		return "redirect:/index/index.do";
	}
	@RequestMapping(value="/logout.do")
	public String loginOut(HttpServletRequest request) {
		request.getSession().removeAttribute("user");
		return "redirect:index.do";
	}
}
