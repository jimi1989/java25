package com.kaishengit.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.kaishengit.entity.Account;

public class BaseServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public Account getCurrAccount(HttpServletRequest req){
		HttpSession session = req.getSession();
		Account currAccount = (Account)session.getAttribute("account");
		return currAccount;
	}
	
	/**
	 * 请求转发跳转方法
	 */
	public void forward(String path, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/" + path + ".jsp").forward(req, resp);
	}
	
	public void sendJson(Object obj, HttpServletResponse resp) throws IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json; charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		out.print(new Gson().toJson(obj));
		out.flush();
		out.close();
		
	}
	
}
