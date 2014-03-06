package com.shopping.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.entity.Forder;
import com.shopping.entity.Users;
import com.shopping.service.UsersManager;
import com.shopping.service.impl.UsersManagerImpl;

public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	UsersManager um = new UsersManagerImpl();

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
			Users users = new Users();
			users.setUlogin(request.getParameter("ulogin"));
			users.setUpass(request.getParameter("upass"));
			users = um.usersLogin(users);
			if (users == null) {// ��¼ʧ��
				request.setAttribute("error", "�û������������");
				request.getRequestDispatcher("/ulogin.jsp").forward(request,
						response);
			} else {
				// ����һ�����ﳵ�����Ժ���
				Forder forder = new Forder();
				request.getSession().setAttribute("forder", forder);
				request.getSession().setAttribute("users", users);// �����û���Ϣ
				if (request.getSession().getAttribute("goUrl") != null) {
					// ˵���û���¼�ɹ���Ҫ��ת����ȥҳ��
					response.sendRedirect(request.getSession()
							.getAttribute("goUrl").toString());
				} else {
					response.sendRedirect(request.getContextPath()
							+ "/index.jsp");
				}

			}
		} else if (status.equals("register")) {
			Users users = new Users();
			users.setUaddress(request.getParameter("uaddress"));
			users.setUemail(request.getParameter("uemail"));
			users.setUlogin(request.getParameter("ulogin"));
			users.setUname(request.getParameter("uname"));
			users.setUpass(request.getParameter("upass"));
			users.setUphone(request.getParameter("uphone"));
			users.setUpost(request.getParameter("upost"));
			users.setUsex(request.getParameter("usex"));
			users = um.usersRegister(users);
			if (users != null) {
				request.getSession().setAttribute("users", users);// �����û���Ϣ
				response.sendRedirect(request.getContextPath() + "/index.jsp");
			} else {
				request.setAttribute("error", "���û����ѱ�ע��");
				request.getRequestDispatcher("/uRegister.jsp").forward(request,
						response);
			}
		} else if (status.equals("logout")) {
			request.getSession().setAttribute("users", null);
			response.sendRedirect(request.getContextPath() + "/index.jsp");

		}
	}

}
