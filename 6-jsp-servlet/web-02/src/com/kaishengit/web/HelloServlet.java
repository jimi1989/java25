package com.kaishengit.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
//		System.out.println("hello.servlet");
		PrintWriter out = resp.getWriter();
		out.print("<html>");
		out.print("<head><title>HelloServlet</title></head>");
		out.print("<body>hello,servlet</body>");
		out.print("</html>");
		
		out.flush();
		out.close();
		
	}

}
