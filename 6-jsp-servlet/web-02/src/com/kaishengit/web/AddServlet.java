package com.kaishengit.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kaishengit.exception.ServiceException;
import com.kaishengit.service.BookService;

public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/add.jsp").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException {
		
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
