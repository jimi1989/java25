package com.kaishengit.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

@WebServlet("/upload")
public class FileuploadServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/fileupload.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 中文乱码
		req.setCharacterEncoding("UTF-8");

		//将表单的enctype属性设置为multipart/form-data之后会导致无法通过req.getparameter("name")来获取表单的值
		String desc = req.getParameter("desc");
		System.out.println("desc:" + desc);
		
		//1.设置文件上传路径
		File saveDir = new File("d:/upload");
		
		if(!saveDir.exists()) {
			saveDir.mkdir();
		}
		
		File tempDir = new File("d:/temp");
		
		if(!tempDir.exists()) {
			tempDir.mkdir();
		}
		
		// 判断表单是否设置enctype属性为mutilpart/form-data
		if(ServletFileUpload.isMultipartContent(req)) {
			DiskFileItemFactory itemFactory = new DiskFileItemFactory();
			// 设置缓冲区大小
			itemFactory.setSizeThreshold(1024);
			// 设置临时文件夹
			itemFactory.setRepository(tempDir);
			
			ServletFileUpload servletFileUpload = new ServletFileUpload(itemFactory);
			// 设置最大上传文件大小
			servletFileUpload.setSizeMax(1024 * 1024 * 10);
			
			try {
				// 获取所有表单元素（包括普通元素和文件元素）包装成FileItem对象的List集合
				List<FileItem> itemList = servletFileUpload.parseRequest(req);
				for(FileItem item : itemList) {
					if(item.isFormField()) {
						// 普通元素
						System.out.println("fildName:" + item.getFieldName()); // 获取表单name的属性值
						System.out.println("getString:" + item.getString()); // 获取表单普通元素的value值
					} else {
						// 文件元素
						System.out.println("fileName:" + item.getFieldName()); // 获取表单文件元素的name属性值
						System.out.println("name:" + item.getName()); // 获取上传文件的文件名
				
						if(StringUtils.isNotEmpty(item.getName())) {

							// 获得文件输入流
							InputStream in = item.getInputStream();
							// 文件输出流
							// 重命名文件
							String fileName = item.getName(); // 1.jpg
							String newFileName = UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf("."));// ef1a-fdf1.jpg
							
							OutputStream out = new FileOutputStream(new File(saveDir, newFileName)); // d:/upload/1.jpg
							
							IOUtils.copy(in, out);
							
							/*byte[] buffer = new byte[1024];
							int len = -1;
							while((len = in.read(buffer)) != -1) {
								out.write(buffer, 0, len);
							}*/
							
							out.flush();
							out.close();
							in.close();
						}
						
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			
			
		} else {
			throw new RuntimeException("enctype属性异常！");
		}
		
		
	}
	
}
