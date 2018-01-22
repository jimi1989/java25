package com.kaishengit.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kaishengit.util.HttpClientUtil;

@WebServlet("/youdao")
public class YoudaoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*String word = req.getParameter("word");
		
		word = new String(word.getBytes("ISO8859-1"),"UTF-8");
		// 进行urlEncode
		URLEncoder.encode(word, "UTF-8");
		String url = "http://fanyi.youdao.com/openapi.do?keyfrom=kaishengit&key=1587754017&type=data&doctype=xml&version=1.1&q=" + word;
		String result = HttpClientUtil.httpClientGet(url, "UTF-8");
		System.out.println("result:" + result);

		// 设置相应头
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/xml;charset=UTF-8");
		
		PrintWriter writer = resp.getWriter();
		writer.print(result);
		
		writer.close();*/
		
		Map<String,String> params = new HashMap<>();
		params.put("name", "jack");
		
		String result = HttpClientUtil.httpClientPost("http://localhost/save", "UTF-8", params);
		System.out.println("result:" + result);
		
		
	}

}
