package com.kaishengit.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/save")
public class SvaeServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 解决post请求的中文乱码问题
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		
		System.out.println(name);
		
		// 告知客户端返回的数据类型为字符串
		resp.setContentType("text/plain;charset=UTF-8");
		//解决响应中文乱码问题的
		resp.setCharacterEncoding("UTF-8");
		PrintWriter writer = resp.getWriter();
		writer.print("保存成功");
		writer.flush();
		writer.close();
	}
	
}
