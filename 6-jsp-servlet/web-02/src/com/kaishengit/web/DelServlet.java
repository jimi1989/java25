package com.kaishengit.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.kaishengit.entity.Admin;
import com.kaishengit.exception.ServiceException;
import com.kaishengit.service.BookService;

public class DelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		Admin admin = (Admin)session.getAttribute("admin");
		if(admin != null) {
			//接收客户端数据
			String id = req.getParameter("id");
			System.out.println("hello");
			BookService bookService = new BookService();
			
			// 调用service进行删除
			try {
				bookService.delBook(id);
				// 重定向跳转到/list
				resp.sendRedirect("/list");
			} catch(ServiceException e) {
				// 手动引发404
				resp.sendError(404, e.getMessage());
			}
		} else {
			//没有登录的情况，返回登录页面
			resp.sendRedirect("/login");
		}
	}

}
