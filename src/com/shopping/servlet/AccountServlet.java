package com.shopping.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.dao.AccountDao;
import com.shopping.dao.CategoryDao;
import com.shopping.dao.ForderDao;
import com.shopping.dao.GoodsDao;
import com.shopping.dao.UserDao;
import com.shopping.dao.impl.AccountDaoImpl;
import com.shopping.dao.impl.CategoryDaoImpl;
import com.shopping.dao.impl.ForderDaoImpl;
import com.shopping.dao.impl.GoodsDaoImpl;
import com.shopping.dao.impl.UserDaoImpl;
import com.shopping.entity.Account;
import com.shopping.entity.Category;
import com.shopping.entity.Forder;
import com.shopping.entity.Goods;
import com.shopping.entity.User;
import com.shopping.service.AccountService;
import com.shopping.service.CategoryService;
import com.shopping.service.ForderService;
import com.shopping.service.GoodsService;
import com.shopping.service.UserService;
import com.shopping.service.impl.AccountServiceImpl;
import com.shopping.service.impl.CategoryServiceImpl;
import com.shopping.service.impl.ForderServiceImpl;
import com.shopping.service.impl.GoodsServiceImpl;
import com.shopping.service.impl.UserServiceImpl;

public class AccountServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	AccountService accountService = new AccountServiceImpl();
	UserService usersService = new UserServiceImpl();
	ForderService forderService = new ForderServiceImpl();
	CategoryService categoryService = new CategoryServiceImpl();
	Category category = null;
	GoodsService goodsService = new GoodsServiceImpl();

	public void destroy() {

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String status = request.getParameter("status");
		if (status.equals("login")) {
			Account account = new Account();
			account.setAlogin(request.getParameter("alogin"));
			account.setApass(request.getParameter("apass"));
			account = accountService.login(request.getParameter("alogin"), request.getParameter("apass"));
			if (account == null) { 
				
				request.setAttribute("error", "用户名或者密码错误!");
				request.getRequestDispatcher("/view/jsp/front/alogin.jsp").forward(request,
						response);
			} else {
				request.getSession().setAttribute("account", account);
				response.sendRedirect("/shopping/view/jsp/admin/index.jsp");
			}
		} else if (status.equals("usersManage")) {

			List<User> users = new ArrayList<User>();
			users = usersService.listAll();
			request.getSession().setAttribute("users", users);

			response.sendRedirect("/shopping/view/jsp/admin/users.jsp");
		} else if (status.equals("deleteUser")) {
			int uid = Integer.parseInt(request.getParameter("uid"));
			usersService.deleteById(uid);
			List<User> users = new ArrayList<User>();
			users = usersService.listAll();
			request.getSession().setAttribute("users", users);

			response.sendRedirect("/shopping/view/jsp/admin/users.jsp");
		} else if (status.equals("userModify")) {
			User user = new User();
			user.setUaddress(request.getParameter("uaddress"));
			user.setUemail(request.getParameter("uemail"));
			// System.out.println(request.getRequestURL());
			user.setUid(Integer.parseInt(request.getParameter("uid")));
			user.setUlogin(request.getParameter("ulogin"));
			user.setUname(request.getParameter("uname"));
			user.setUpass(request.getParameter("upass"));
			user.setUphone(request.getParameter("uphone"));
			user.setUpost(request.getParameter("upost"));
			user.setUsex(request.getParameter("usex"));
			usersService.modify(user);
			List<User> users = new ArrayList<User>();
			users = usersService.listAll();
			request.getSession().setAttribute("users", users);
			response.sendRedirect("/shopping/view/jsp/admin/users.jsp");

		} else if (status.equals("forderManage")) {
			List<Forder> forders = new ArrayList<Forder>();
			forders = forderService.listAll();
			request.getSession().setAttribute("forders", forders);
			response.sendRedirect("/shopping/view/jsp/admin/forder.jsp");

		} else if (status.equals("forderModify")) {
			int fid = Integer.parseInt(request.getParameter("fid"));
			int sid = Integer.parseInt(request.getParameter("sid"));
			forderService.updateForderStatus(fid, sid);
			response.sendRedirect("/shopping/view/jsp/admin/forder.jsp");
		} else if (status.equals("categoryAndGoodsInfo")) {
			List<Category> categorys = categoryService.listAll();
			request.getSession().setAttribute("categorys", categorys);
			response.sendRedirect("/shopping/view/jsp/admin/category_goods_info.jsp");
		} else if (status.equals("deleteCategory")) {
			categoryService.delete(Integer.parseInt(request.getParameter("cid")));
			response.sendRedirect("/shopping/AccountSer?status=categoryAndGoodsInfo");
		} else if (status.equals("categoryModify")) {
			category = new Category();
			Account account = new Account();
			account.setAid(request.getParameter("aid"));
			category.setAccount(account);
			category.setChot(Boolean.parseBoolean(request.getParameter("chot")));
			category.setCid(Integer.parseInt(request.getParameter("cid")));
			category.setCtype(request.getParameter("ctype"));
			categoryService.update(category);
			response.sendRedirect("/shopping/AccountSer?status=categoryAndGoodsInfo");
		} else if (status.equals("addCategory")) {
			category = new Category();
			Account account = new Account();
			account.setAid(request.getParameter("aid"));
			category.setAccount(account);
			category.setChot(Boolean.parseBoolean(request.getParameter("chot")));
			category.setCtype(request.getParameter("ctype"));
			categoryService.save(category);
			response.sendRedirect("/shopping/AccountSer?status=categoryAndGoodsInfo");
		} else if (status.equals("getGoodsInfo")) {
			int cid = Integer.parseInt(request.getParameter("cid"));
			List<Goods> goods = goodsService.getGoodsByCid(cid);
			request.getSession().setAttribute("goods", goods);
			response.sendRedirect("/shopping/admin/goods.jsp");
		} else if (status.equals("deleteGoods")) {
			int gid = Integer.parseInt(request.getParameter("gid"));
			int cid = Integer.parseInt(request.getParameter("cid"));
			goodsService.deleteByGid(gid);
			response.sendRedirect("/shopping/AccountSer?status=getGoodsInfo&cid="
					+ cid);
		} else if (status.equals("goodsModify")) {
			Goods goods = new Goods();
			Category category = new Category();
			category.setCid(Integer.parseInt(request.getParameter("cid")));
			goods.setCategory(category);
			goods.setGid(Integer.parseInt(request.getParameter("gid")));
			goods.setGiscommend(Boolean.parseBoolean(request
					.getParameter("giscommend")));
			goods.setGisopen(Boolean.parseBoolean(request
					.getParameter("gisopen")));
			goods.setGname(request.getParameter("gname"));
			goods.setGpic(request.getParameter("gpic"));
			goods.setGremark(request.getParameter("gremark"));
			goods.setGxremark(request.getParameter("gxremark"));
			goodsService.update(goods);
			response.sendRedirect("/shopping/AccountSer?status=getGoodsInfo&cid="
					+ Integer.parseInt(request.getParameter("cid")));
		} else if (status.equals("addGoods")) {
			Goods goods = new Goods();
			Category category = new Category();
			category.setCid(Integer.parseInt(request.getParameter("cid")));
			goods.setCategory(category);
			goods.setGiscommend(Boolean.parseBoolean(request
					.getParameter("giscommend")));
			goods.setGisopen(Boolean.parseBoolean(request
					.getParameter("gisopen")));
			goods.setGname(request.getParameter("gname"));
			goods.setGpic(request.getParameter("gpic"));
			goods.setGprice(Double.parseDouble(request.getParameter("gprice")));
			goods.setGremark(request.getParameter("gremark"));
			goods.setGxremark(request.getParameter("gxremark"));
			goodsService.save(goods);
			response.sendRedirect("/shopping/AccountSer?status=getGoodsInfo&cid="
					+ Integer.parseInt(request.getParameter("cid")));

		} else if (status.equals("goodsList")) { // ������Ʒ�б�չʾ
			List<Goods> goodslist = new ArrayList<Goods>();
			int cid = Integer.parseInt(request.getParameter("cid"));
			String ctype = request.getParameter("ctype");
			request.getSession().setAttribute("ctype", ctype);

			// System.out.println(cid);
			goodslist = goodsService.getGoodsByCid(cid);
			request.getSession().setAttribute("goodslist", goodslist);
			response.sendRedirect("/shopping/goodslist.jsp");
		} else if (status.equals("alogout")) {
			request.getSession().setAttribute("account", null);
			response.sendRedirect("/shopping/view/jsp/front/alogin.jsp");
		}
	}

	public void init() throws ServletException {

	}

}
