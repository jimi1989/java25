package com.kaishengit.web;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kaishengit.service.AdminService;

public class HelloServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	int count = 10; // 有状态的 无状态的 实例变量,避免使用有状态的实例变量
	AdminService adminService = new AdminService();
	
	@Override
	public void init() throws ServletException {
		
		ServletConfig config = getServletConfig();
		String value = config.getInitParameter("name");
		System.out.println(value);
//		System.out.println("helloServlet init...");
		
	}
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// 解决硬编码问题
//		String name = config.getInitParameter("name");
//		String password = config.getInitParameter("password");
//		System.out.println(name + "-->" + password);
		
		Enumeration<String> en = config.getInitParameterNames();
		while(en.hasMoreElements()) {
			String name = en.nextElement();
			String value = config.getInitParameter(name);
			System.out.println(name + "-->" + value);
		}
		
	}
	
	public HelloServlet(){
		System.out.println("HelloSevlet create...");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("hello,get");
		synchronized (this) {
			count --;
		}
		
	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
	}
	
	@Override
	public void destroy() {
		System.out.println("helloServlet destroy ...");
	}
	
	
}
