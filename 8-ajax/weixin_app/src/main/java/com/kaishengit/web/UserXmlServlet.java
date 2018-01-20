package com.kaishengit.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kaishengit.entity.User;

@WebServlet("/user.xml")
public class UserXmlServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user1 = new User(1, "jack", 23);
		User user2 = new User(2, "tom", 25);
		User user3 = new User(3, "rose", 33);
		User user4 = new User(4, "hank", 53);

		List<User> userList = Arrays.asList(user1, user2, user3, user4);

		// 设置相应头
		resp.setContentType("text/xml;charset=UTF-8");
		// 解决响应中文乱码
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter writer = resp.getWriter();
		writer.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		writer.print("<users>");
		for(User user : userList) {
			writer.print("<user id=\"" + user.getId() + "\">");
			writer.print("<name>" + user.getName() + "</name>");
			writer.print("<age>" + user.getAge() + "</age>");
			writer.print("</user>");
		}
		writer.print("</users>");
		
		writer.flush();
		writer.close();
		
		
		
	}

}
