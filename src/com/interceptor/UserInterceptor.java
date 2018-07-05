package com.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.entity.User;

public class UserInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		User user = (User)request.getSession().getAttribute("user");
		if(user == null) {
			String path = request.getContextPath();
			String basePath = request.getScheme() + "://" + request.getServerName() + ":" +request.getServerPort() + path + "/";
			response.sendRedirect(basePath + "login");
			return false;
		}
		return true;
	}
}
