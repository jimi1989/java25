package com.kaishengit.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kaishengit.entity.Admin;
import com.kaishengit.service.AdminService;

public class HelloServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	int count = 10; // 有状态的 无状态的 实例变量,避免使用有状态的实例变量
	AdminService adminService = new AdminService();
	
/*	@Override
	public void init() throws ServletException {
		
		ServletConfig config = getServletConfig();
		String value = config.getInitParameter("name");
		System.out.println(value);
//		System.out.println("helloServlet init...");
		
	}*/
	
	
	/*@Override
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
	}*/
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("hahaha，我终于过来了...");
		
		/*Admin admin = new Admin();
		admin.setId(1001);
		admin.setName("admin");
		admin.setPassword("123123");
		
		List<String> lists = new ArrayList<>();
		lists.add("A1");
		lists.add("A2");
		lists.add("A3");
		lists.add("A4");
		lists.add("A5");
		
		req.setAttribute("name", "tom");
		req.setAttribute("address", "北京");
		
		req.setAttribute("admin", admin);
		
		req.setAttribute("lists", lists);
		
		req.setAttribute("message", "<span style='color:red'>登录成功</span>");
		
		HttpSession session = req.getSession();
		session.setAttribute("address", "河南焦作");
		
		ServletContext context = req.getServletContext(); 
		context.setAttribute("status", "ok");
		
		
		req.getRequestDispatcher("/WEB-INF/views/hello.jsp").forward(req, resp);*/
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("hello,post");
		synchronized (this) {
			count --;
		}
		
	
	}
	
	@Override
	public void destroy() {
		System.out.println("helloServlet destroy ...");
	}
	
	
}
