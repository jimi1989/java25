package com.kaishengit.web.disk;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.kaishengit.service.DiskService;
import com.kaishengit.util.AjaxResult;
import com.kaishengit.web.BaseServlet;

@WebServlet("/disk/upload")
@MultipartConfig
public class DiskUploadServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	DiskService service = new DiskService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Part part = req.getPart("file");
		// 获取文件上传的二进制流
		InputStream input = part.getInputStream();
		
		// 获得文件上传的原始名称
		String name = req.getParameter("name");// part.getSubmittedFileName(); error:tomcat7不支持
		// 获得文件上传的大小
		long fileSize = part.getSize();
		
		// 从formData中获得pid 
		String pid = req.getParameter("pid");
		
		// 获得accountId
		try{
			int accountId = getCurrAccount(req).getId();
			service.saveNewFile(input, name, fileSize, Integer.parseInt(pid), accountId);
			sendJson(AjaxResult.success(), resp);
		} catch(NullPointerException e) {
			sendJson(AjaxResult.error("登录信息已过期，请重新登录"), resp);
		}
		
	}
	
}
