package com.shopping.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.entity.Account;
import com.shopping.entity.Forder;
import com.shopping.entity.Goods;
import com.shopping.entity.Sorder;
import com.shopping.entity.Status;
import com.shopping.entity.User;
import com.shopping.service.ForderService;
import com.shopping.service.impl.ForderServiceImpl;

public class ForderServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ForderService forderService = new ForderServiceImpl();

	public void init() throws ServletException {
		super.init();
	}

	public void destory() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String status = request.getParameter("status");
		if (status.equals("buy")) {
			Forder forder = (Forder) request.getSession()
					.getAttribute("forder");
			Sorder sorder = new Sorder();
			sorder.setSname(request.getParameter("gname"));
			sorder.setSnumber(1);
			sorder.setSprice(Double.parseDouble(request.getParameter("gprice")));
			Goods goods = new Goods();
			goods.setGid(Integer.parseInt(request.getParameter("gid")));
			sorder.setGoods(goods);
			request.getSession().setAttribute("forder",
					forderService.addSorder(forder, sorder));
			response.sendRedirect("/shopping/view/jsp/member/showCar.jsp");
		} else if (status.equals("deleteForder")) {
			request.getSession().setAttribute("forder", new Forder());
			response.sendRedirect("/shopping/view/jsp/member/showCar.jsp");
		} else if (status.equals("saveForder")) {
			Forder forder = (Forder) request.getSession()
					.getAttribute("forder");
			forder.setFname(request.getParameter("fname"));
			forder.setFemail(request.getParameter("femail"));
			forder.setFphone(request.getParameter("fphone"));
			forder.setFpost(request.getParameter("fpost"));
			forder.setFremark(request.getParameter("fremark"));
			forder.setFaddress(request.getParameter("faddress"));
			Account account = new Account();
			forder.setAccount(account);
			forder.setStatus(new Status(1));
			forder.setUsers((User) request.getSession().getAttribute("users"));
			request.getSession().setAttribute("forder",
					forderService.save(forder));
			response.sendRedirect("/shopping/view/jsp/member/chooseBank.jsp");
		} else if (status.equals("updateSorder")) {
			int gid = Integer.parseInt(request.getParameter("gid"));
			int snumber = Integer.parseInt(request.getParameter("snumber"));
			Forder forder = (Forder) request.getSession()
					.getAttribute("forder");
			forder = forderService.updateSorder(forder, gid, snumber);

			request.getSession().setAttribute("forder", forder);
			response.getWriter().write(forder.getFtotal() + "");
		} else if (status.equals("deleteSorder")) {
			int gid = Integer.parseInt(request.getParameter("gid"));
			Forder forder = (Forder) request.getSession()
					.getAttribute("forder");
			request.getSession().setAttribute("forder",
					forderService.deleteSorder(forder, gid));
			response.sendRedirect("/shopping/view/jsp/member/showCar.jsp");
		}
	}

}
