package com.kaishengit.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kaishengit.entity.Admin;

public class LoginFilter extends AbstractFilter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		// 获取请求路径
		String uri = req.getRequestURI();
		// 如果是如下路径资源，则直接通过，不用校验是否登录
		if("/".equals(uri) || "/login".equals(uri) || "/index.jsp".equals(uri) 
				|| uri.startsWith("/static") ) {
			chain.doFilter(req, resp);
		} else {
			// 如果是诸如/add /list等资源需要判断是否登录，如果session中有admin对象，则已经登录过，直接通过过滤器
			// 否则视为还没有登录，重定向到登录页面
			HttpSession session = req.getSession();
			Admin admin = (Admin)session.getAttribute("admin");
			if(admin != null) {
				chain.doFilter(req, resp);
			}else {
				resp.sendRedirect("/login?callback=" + uri);
			}
		}
		
		
	}

}
