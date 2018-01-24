package com.kaishengit.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import com.kaishengit.util.Config;
import com.kaishengit.util.HttpClientUtil;


@WebServlet("/youdaozhiyun")
public class YoudaoZhiYunServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String p = req.getParameter("p");
		p = new String(p.getBytes("ISO-8859-1"),"UTF-8");
		
		Map<String,String> params = new HashMap<>();
		params.put("q", p);
		params.put("from","auto");
		params.put("to","auto");
		params.put("appKey",Config.get("youdao.appkey"));
		String salt = String.valueOf((int)(Math.random()*100));
		System.out.println("salt:" + salt);
		params.put("salt",salt);
		//appKey+q+salt+密钥 md5加密
		String sign = DigestUtils.md5Hex(Config.get("youdao.appkey") + p + salt +Config.get("youdao.primarykey"));
		params.put("sign", sign);
		
		String url = HttpClientUtil.getUrlWithQueryString("http://openapi.youdao.com/api", params);
		
		System.out.println("url:" + url);
		
		String result = HttpClientUtil.httpClientGet(url, "UTF-8");
	
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json;charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		out.print(result);
		
		out.flush();
		out.close();
		
	}
}
