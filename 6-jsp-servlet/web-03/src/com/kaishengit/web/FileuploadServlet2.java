package com.kaishengit.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.FileUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;

@WebServlet("/upload2")
@MultipartConfig
public class FileuploadServlet2 extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/fileupload2.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		// 获得普通表单元素的值
//		String desc = req.getParameter("desc");
//		System.out.println(desc);
		
		// 获得文件元素的属性值
		Part part = req.getPart("file1");
		System.out.println("name:" + part.getName()); // name属性值
		System.out.println("contentType:" + part.getContentType()); // 文件MIME类型
		System.out.println("size:" + part.getSize()); // 文件大小 字节
		System.out.println("readSize:" + FileUtils.byteCountToDisplaySize(part.getSize())); // 人类可阅读的文件大小
		System.out.println("submittedFileName:" + part.getSubmittedFileName()); // 上传文件的文件名
		
		// 获得输入流
		InputStream in = part.getInputStream();
		
		// 获得输出流
		File saveDir = new File("d:/upload");
		
		String fileName = part.getSubmittedFileName(); // 1.jpg
		String newFileName = UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf("."));   
		
		OutputStream out = new FileOutputStream(new File(saveDir,newFileName));
		
		IOUtils.copy(in, out);
		
		out.flush();
		out.close();
		in.close();
	}
	
}
