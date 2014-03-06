package com.shopping.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.entity.Forder;
import com.shopping.entity.User;

public class UsersFilter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filter) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		if(req.getSession().getAttribute("users")==null){
			//�Ƿ�����,�Զ���ת���û���¼ҳ��
			req.setAttribute("error", "������Ʒ���ȵ�¼");
			req.getSession().setAttribute("goUrl",req.getRequestURI() + "?" + req.getQueryString());
			req.getRequestDispatcher("/ulogin.jsp").forward(request, response);
		}else{
			HttpServletResponse res=(HttpServletResponse)response;
			filter.doFilter(request, response);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
