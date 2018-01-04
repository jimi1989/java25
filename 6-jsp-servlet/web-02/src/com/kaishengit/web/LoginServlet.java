package com.kaishengit.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kaishengit.dao.AccountDao;
import com.kaishengit.entity.Account;

public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//获取客户端控件元素的值
		String userName = req.getParameter("userName");
		String password = req.getParameter("pass");

		AccountDao accDao = new AccountDao();
		Account account = accDao.findByName(userName);
		
		if(account != null && password.equals(account.getPassword())) {
			
			List<String> lists = new ArrayList<>();
			lists.add("篮球");
			lists.add("唱歌");
			lists.add("跳舞");
			
			req.setAttribute("userName", userName);
			req.setAttribute("money", account.getMoney());
			req.setAttribute("lists", lists);
			
			req.getRequestDispatcher("/home.jsp").forward(req, resp);
			
		} else {
			resp.sendRedirect("/login.jsp?error=1001&num=1002");
		}
		
		
		
		
		
		
		
		
		
		
		
		
//		if("tom".equals(userName) && "123123".equals(password)) {
//			System.out.println("登录成功");
//			List<String> lists = new ArrayList<>();
//			lists.add("篮球");
//			lists.add("唱歌");
//			lists.add("跳舞");
//			
//			
//			req.setAttribute("userName", userName);
//			req.setAttribute("money", "10000");
//			req.setAttribute("lists", lists);
//			
//			// 请求转发
//			req.getRequestDispatcher("/home.jsp").forward(req, resp);
////			RequestDispatcher rd = req.getRequestDispatcher("/home.jsp");
////			rd.forward(req, resp);
//			
//			
//			
//			// 重定向
//			//resp.sendRedirect("/home.jsp");
//		} else {
//			System.out.println("登录失败");
//			resp.sendRedirect("/login.jsp?error=1001");
//		}
	
	}
	
	
}
