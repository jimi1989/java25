package com.kaishengit.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kaishengit.entity.Message;
import com.kaishengit.service.MessageService;

@WebServlet("/message")
public class MessageServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String maxId = req.getParameter("maxId");
		
		MessageService service = new MessageService();
		List<Message> messages = service.findMesssages(maxId);
		
		String json = new Gson().toJson(messages);
		// 设置json的content-type
		resp.setContentType("application/json; charset=UTF-8"); 
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();
		out.print(json);
		out.flush();
		out.close();
	
	}
	
	
}
