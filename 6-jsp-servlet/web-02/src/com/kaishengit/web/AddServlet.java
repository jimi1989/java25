package com.kaishengit.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kaishengit.entity.Admin;
import com.kaishengit.exception.ServiceException;
import com.kaishengit.service.BookService;

public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Admin admin = (Admin)session.getAttribute("admin");
		if(admin != null) {
			req.getRequestDispatcher("/WEB-INF/views/add.jsp").forward(req, resp);
		} else {
			//没有登录的情况，返回登录页面
			resp.sendRedirect("/login");
		}
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException {
		
		// 中文乱码 
		// 1.post提交中文乱码
		req.setCharacterEncoding("UTF-8");
		
		// 2.接收表单的值
		String name = req.getParameter("name");
		String author = req.getParameter("author");
		String publish = req.getParameter("publish");
		String isbn = req.getParameter("isbn");
		String num = req.getParameter("num");
		
		BookService service = new BookService();
		try {
			service.addBook(name,author,publish,isbn,num);
			// 跳转成功页面   
			resp.sendRedirect("/list");
			
		} catch(ServiceException e) {
			// 请求转发
			req.setAttribute("name", name);
			req.setAttribute("author", author);
			req.setAttribute("publish", publish);
			req.setAttribute("isbn", isbn);
			req.setAttribute("num", num);
			req.setAttribute("message", e.getMessage());
			
			req.getRequestDispatcher("/WEB-INF/views/add.jsp").forward(req, resp);
		}
		
	}

}
