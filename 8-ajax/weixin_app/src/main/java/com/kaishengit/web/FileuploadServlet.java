package com.kaishengit.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;

@MultipartConfig
@WebServlet("/file/upload")
public class FileuploadServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		String id = req.getParameter("id");
//		String type = req.getParameter("type");
//		String name = req.getParameter("name");
//		String size = req.getParameter("size");
		
/*		System.out.println(id);
		System.out.println(type);
		System.out.println(name);
		System.out.println(size);
*/		
		
		/*// 通过Content-Disposition获得对应的字符串值
		String content = part.getHeader("Content-Disposition");
		// 截取content中的fileName值
		String fileName = content.split(";")[2].split("\"")[1];*/
		Part part = req.getPart("file");

		/*String fileName = req.getParameter("fileName");
		System.out.println(fileName);*/
		String content = part.getHeader("Content-Disposition");
		// 截取content中的fileName值
		String fileName = content.split(";")[2].split("\"")[1];
		
		File file = new File("d:/upload",fileName);
		OutputStream out = new FileOutputStream(file);
		
		InputStream in = part.getInputStream();
		IOUtils.copy(in, out);
		
		out.flush();
		out.close();
		in.close();
		
		Map<String,Object> res = new HashMap<>();
//		res.put("state", "success");
//		res.put("data", "http://localhost/avatar?name="+fileName);
		
		res.put("success", true);
		res.put("file_path",  "http://localhost/avatar?name="+fileName);
		
		
		resp.setContentType("application/json; charset=UTF-8"); 
		resp.setCharacterEncoding("UTF-8");
		
		String json = new Gson().toJson(res);
		PrintWriter writer = resp.getWriter();
		writer.print(json);
		writer.flush();
		writer.close();
		
		
	}
	
}
