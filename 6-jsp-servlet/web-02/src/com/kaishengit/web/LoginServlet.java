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
import com.kaishengit.service.AdminService;

public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String userName = req.getParameter("username");
		String pass = req.getParameter("password");
		String callback = req.getParameter("callback");
		
		AdminService service = new AdminService();
		try {
			Admin admin = service.login(userName,pass);
			
			HttpSession session = req.getSession();
			session.setAttribute("admin", admin);
			
			// µÇÂ¼³É¹¦
			if(StringUtils.isNotEmpty(callback)) {
				resp.sendRedirect(callback);
			} else {
				resp.sendRedirect("/list");
			}
		} catch(ServiceException e) {
			req.setAttribute("message", e.getMessage());
			req.setAttribute("username", userName);
			req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
		}
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
