package com.shopping.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.entity.Forder;
import com.shopping.entity.User;
import com.shopping.service.UserService;
import com.shopping.service.impl.UserServiceImpl;

public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
//	UsersManager um = new UsersManagerImpl();
	UserService um = new UserServiceImpl();
	public void destory() {
		super.destroy();
	}

	public void init() throws ServletException {
		super.init();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String status = request.getParameter("status");
		if (status.equals("login")) {
			User users = new User();
			users.setUlogin(request.getParameter("ulogin"));
			users.setUpass(request.getParameter("upass"));
			users = um.login(request.getParameter("ulogin"), request.getParameter("upass"));
			if (users == null) {// ��¼ʧ��
				request.setAttribute("error", "用户名或密码错误");
				request.getRequestDispatcher("/shopping/view/jsp/front/ulogin.jsp").forward(request,
						response);
			} else {
				Forder forder = new Forder();
				request.getSession().setAttribute("forder", forder);
				request.getSession().setAttribute("users", users);
				if (request.getSession().getAttribute("goUrl") != null) {
					response.sendRedirect(request.getSession()
							.getAttribute("goUrl").toString());
				} else {
					response.sendRedirect(request.getContextPath()
							+ "/index.jsp");
				}

			}
		} else if (status.equals("register")) {
			User users = new User();
			users.setUaddress(request.getParameter("uaddress"));
			users.setUemail(request.getParameter("uemail"));
			users.setUlogin(request.getParameter("ulogin"));
			users.setUname(request.getParameter("uname"));
			users.setUpass(request.getParameter("upass"));
			users.setUphone(request.getParameter("uphone"));
			users.setUpost(request.getParameter("upost"));
			users.setUsex(request.getParameter("usex"));
			users = um.register(users);
			if (users != null) {
				request.getSession().setAttribute("users", users);// �����û���Ϣ
				response.sendRedirect(request.getContextPath() + "/index.jsp");
			} else {
				request.setAttribute("error", "���û����ѱ�ע��");
				request.getRequestDispatcher("/shopping/view/jsp/front/uRegister.jsp").forward(request,
						response);
			}
		} else if (status.equals("logout")) {
			request.getSession().setAttribute("users", null);
			response.sendRedirect(request.getContextPath() + "/index.jsp");

		}
	}

}
