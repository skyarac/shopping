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
import com.shopping.dao.UsersDao;
import com.shopping.dao.impl.AccountDaoImpl;
import com.shopping.dao.impl.CategoryDaoImpl;
import com.shopping.dao.impl.ForderDaoImpl;
import com.shopping.dao.impl.GoodsDaoImpl;
import com.shopping.dao.impl.UsersDaoImpl;
import com.shopping.entity.Account;
import com.shopping.entity.Category;
import com.shopping.entity.Forder;
import com.shopping.entity.Goods;
import com.shopping.entity.Users;

public class AccountServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	AccountDao accountDao = new AccountDaoImpl();
	UsersDao usersDao = new UsersDaoImpl();
	ForderDao forderDao = new ForderDaoImpl();
	CategoryDao categoryDao = new CategoryDaoImpl();
	Category category = null;
	GoodsDao goodsDao = new GoodsDaoImpl();

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
			account = accountDao.queryAccount(account);
			if (account == null) { 
				// 登录失败
				request.setAttribute("error", "对不起登录失败!");
				request.getRequestDispatcher("/view/jsp/front/alogin.jsp").forward(request,
						response);
			} else {
				request.getSession().setAttribute("account", account);
				response.sendRedirect("/shopping/view/jsp/admin/index.jsp");
			}
		} else if (status.equals("usersManage")) {

			List<Users> users = new ArrayList<Users>();
			users = usersDao.getUsers();
			request.getSession().setAttribute("users", users);

			response.sendRedirect("/shopping/view/jsp/admin/users.jsp");
		} else if (status.equals("deleteUser")) {
			int uid = Integer.parseInt(request.getParameter("uid"));
			usersDao.delete(uid);
			List<Users> users = new ArrayList<Users>();
			users = usersDao.getUsers();
			request.getSession().setAttribute("users", users);

			response.sendRedirect("/shopping/view/jsp/admin/users.jsp");
		} else if (status.equals("userModify")) {
			Users user = new Users();
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
			usersDao.usersModify(user);
			List<Users> users = new ArrayList<Users>();
			users = usersDao.getUsers();
			request.getSession().setAttribute("users", users);
			response.sendRedirect("/shopping/view/jsp/admin/users.jsp");

		} else if (status.equals("forderManage")) {
			List<Forder> forders = new ArrayList<Forder>();
			forders = forderDao.getForders();
			request.getSession().setAttribute("forders", forders);
			response.sendRedirect("/shopping/view/jsp/admin/forder.jsp");

		} else if (status.equals("forderModify")) {
			int fid = Integer.parseInt(request.getParameter("fid"));
			int sid = Integer.parseInt(request.getParameter("sid"));
			forderDao.updateForderStatus(fid, sid);
			response.sendRedirect("/shopping/view/jsp/admin/forder.jsp");
		} else if (status.equals("categoryAndGoodsInfo")) {
			List<Category> categorys = categoryDao.getCategorys();
			request.getSession().setAttribute("categorys", categorys);
			response.sendRedirect("/shopping/view/jsp/admin/category_goods_info.jsp");
		} else if (status.equals("deleteCategory")) {
			categoryDao.delete(Integer.parseInt(request.getParameter("cid")));
			response.sendRedirect("/shopping/AccountSer?status=categoryAndGoodsInfo");
		} else if (status.equals("categoryModify")) {
			category = new Category();
			Account account = new Account();
			account.setAid(request.getParameter("aid"));
			category.setAccount(account);
			category.setChot(Boolean.parseBoolean(request.getParameter("chot")));
			category.setCid(Integer.parseInt(request.getParameter("cid")));
			category.setCtype(request.getParameter("ctype"));
			categoryDao.categoryModify(category);
			response.sendRedirect("/shopping/AccountSer?status=categoryAndGoodsInfo");
		} else if (status.equals("addCategory")) {
			category = new Category();
			Account account = new Account();
			account.setAid(request.getParameter("aid"));
			category.setAccount(account);
			category.setChot(Boolean.parseBoolean(request.getParameter("chot")));
			category.setCtype(request.getParameter("ctype"));
			categoryDao.save(category);
			response.sendRedirect("/shopping/AccountSer?status=categoryAndGoodsInfo");
		} else if (status.equals("getGoodsInfo")) {
			int cid = Integer.parseInt(request.getParameter("cid"));
			List<Goods> goods = goodsDao.queryGoodsByCid(cid);
			request.getSession().setAttribute("goods", goods);
			response.sendRedirect("/shopping/admin/goods.jsp");
		} else if (status.equals("deleteGoods")) {
			int gid = Integer.parseInt(request.getParameter("gid"));
			int cid = Integer.parseInt(request.getParameter("cid"));
			goodsDao.deleteByGid(gid);
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
			goodsDao.goodsModify(goods);
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
			goodsDao.save(goods);
			response.sendRedirect("/shopping/AccountSer?status=getGoodsInfo&cid="
					+ Integer.parseInt(request.getParameter("cid")));

		} else if (status.equals("goodsList")) { // 分类商品列表展示
			List<Goods> goodslist = new ArrayList<Goods>();
			int cid = Integer.parseInt(request.getParameter("cid"));
			String ctype = request.getParameter("ctype");
			request.getSession().setAttribute("ctype", ctype);

			// System.out.println(cid);
			goodslist = goodsDao.queryGoodsByCid(cid);
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
