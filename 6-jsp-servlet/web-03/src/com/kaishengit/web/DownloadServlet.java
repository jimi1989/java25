package com.kaishengit.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 获取下载的文件名
		String fileName = req.getParameter("fileName");
		String name = req.getParameter("name");
		// get请求中文乱码
//		fileName = new String(fileName.getBytes("ISO8859-1"),"UTF-8");
		
		File saveDir = new File("d:/upload");
		File file = new File(saveDir, fileName);
		
		if(file.exists()) {
			// 下载文件
			// 获取文件输入流
			InputStream in = new FileInputStream(file);
			// 获取输出流 (响应输出流)
			OutputStream out = resp.getOutputStream();
			// name不为空 下载
			if(StringUtils.isNotEmpty(name)) {
				// 设置MIME类型
				resp.setContentType("application/octet-stream");
				// 设置文件名
				name = new String(name.getBytes("UTF-8"),"ISO8859-1");
				resp.addHeader("Content-Disposition", "attachment; filename=\"" + name + "\"");
				// 设置文件总大小
				resp.setContentLengthLong(file.length());
			}
			
			IOUtils.copy(in, out);
			out.flush();
			out.close();
			in.close();
			
		} else {
			resp.sendError(404, "参数异常");
		}
	}
	
}
