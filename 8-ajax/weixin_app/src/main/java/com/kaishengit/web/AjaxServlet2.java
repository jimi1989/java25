package com.kaishengit.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajax2")
public class AjaxServlet2 extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		// 解决get请求的中文乱码问题
		name = new String(name.getBytes("ISO8859-1"),"UTF-8");
		
		PrintWriter writer = resp.getWriter();
		
		if("tom".equals(name)) {
			System.out.println("该账号不可用");
			writer.print("no");
		} else {
			System.out.println("该帐号可用");
			writer.print("yes");
		}
		writer.flush();
		writer.close();
	}
	
}
