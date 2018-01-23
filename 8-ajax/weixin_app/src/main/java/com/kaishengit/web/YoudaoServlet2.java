package com.kaishengit.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kaishengit.util.HttpClientUtil;

@WebServlet("/youdao2")
public class YoudaoServlet2 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String word = req.getParameter("word");
		
		word = new String(word.getBytes("ISO8859-1"),"UTF-8");
		// 进行urlEncode
		URLEncoder.encode(word, "UTF-8");
		String url = "http://fanyi.youdao.com/openapi.do?keyfrom=kaishengit&key=1587754017&type=data&doctype=json&version=1.1&q=" + word;
		String result = HttpClientUtil.httpClientGet(url, "UTF-8");
		// 设置相应头
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json; charset=UTF-8");
		
		PrintWriter writer = resp.getWriter();
		writer.print(result);
		
		writer.close();
		
		
		
		
	}

}
