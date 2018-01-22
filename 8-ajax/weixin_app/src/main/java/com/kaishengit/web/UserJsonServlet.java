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

import com.google.gson.Gson;
import com.kaishengit.entity.User;

@WebServlet("/user.json")
public class UserJsonServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user1 = new User(1, "jack", 23);
		User user2 = new User(2, "tom", 25);
		User user3 = new User(3, "rose", 33);
		User user4 = new User(4, "hank", 53);

		List<User> userList = Arrays.asList(user1, user2, user3, user4);

		String result = new Gson().toJson(userList);
		
		// 设置json的响应头
		resp.setContentType("application/json;charset=UTF-8");
		// 解决中文乱码
		resp.setCharacterEncoding("UTF-8");
		PrintWriter writer = resp.getWriter();
		writer.println(result);
		writer.flush();
		writer.close();
		
	}

}
