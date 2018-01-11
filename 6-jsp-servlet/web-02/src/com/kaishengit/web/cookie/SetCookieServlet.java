package com.kaishengit.web.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SetCookieServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie cookie = new Cookie("playid", "1001");
		// 设置常用属性
		// 所属域名
		cookie.setDomain("localhost");
		//设置路径
		cookie.setPath("/");
		// 生存周期
		cookie.setMaxAge(60 * 60 * 24 * 30);
		
		resp.addCookie(cookie);
		
		Cookie cookie2 = new Cookie("productId", "2006");
		cookie2.setDomain("localhost");
		cookie2.setPath("/");
		cookie2.setMaxAge(60 * 60 * 24 * 30);
		cookie2.setHttpOnly(true);
		resp.addCookie(cookie2);
		
	}
	
}
