package com.shopping.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.shopping.entity.User;

public class UserLoginInterceptor extends HandlerInterceptorAdapter {
	private String loginUrl;
	private String returnUrl;
	private String[] excludeUrls;
	
	public String[] getExcludeUrls() {
		return excludeUrls;
	}

	public void setExcludeUrls(String[] excludeUrls) {
		this.excludeUrls = excludeUrls;
	}

	public String getLoginUrl() {
		return loginUrl;
	}

	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		session.setAttribute("site", "shopping");
		User user = (User) session.getAttribute("user");
		
		String requestUrl = request.getRequestURL().toString();
		String return_url = request.getParameter("returnUrl");
		for(int i = 0 ; i <this.excludeUrls.length ; i++) {
			if(requestUrl.indexOf(this.excludeUrls[i]) != -1 || return_url == returnUrl) {
				return true;
			}
		}
		
		if (null == user) {
			response.sendRedirect(getLoginUrl(request));
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}
	
	private String getLoginUrl(HttpServletRequest request) {
		StringBuilder buff = new StringBuilder();
		if (loginUrl.startsWith("/")) {
			String ctx = request.getContextPath();
			buff.append(ctx);
		}
		buff.append(loginUrl).append("?");
		buff.append("returnUrl").append("=").append(loginUrl);
		return buff.toString();
	}
}
