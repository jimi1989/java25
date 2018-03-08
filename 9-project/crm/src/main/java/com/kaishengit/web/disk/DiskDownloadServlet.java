package com.kaishengit.web.disk;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import com.kaishengit.entity.Disk;
import com.kaishengit.service.DiskService;
import com.kaishengit.util.Config;
import com.kaishengit.web.BaseServlet;

@WebServlet("/disk/download")
public class DiskDownloadServlet extends BaseServlet{

	private static final long serialVersionUID = 1L;

	DiskService service = new DiskService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String diskId = req.getParameter("id");
		String fileName = req.getParameter("fileName");
	
		fileName = new String(fileName.getBytes("ISO8859-1"), "UTF-8");
		System.out.println(fileName);
		
		if(StringUtils.isNumeric(diskId)) {
			Disk disk = service.findDiskById(Integer.parseInt(diskId));
			if(disk == null) {
				// 根据id查找对应的disk对象不存在报 error
				resp.sendError(404, "参数异常");
			} else {
				String filePath = Config.get("file.upload.path");
				InputStream input = new FileInputStream(new File(filePath, disk.getSaveName()));
				OutputStream output = resp.getOutputStream();
				
				if(StringUtils.isNotEmpty(fileName)) {
					// 下载
					// 设置MIME类型
					resp.setContentType("application/octet-stream");
					// 设置文件名
					fileName = new String(fileName.getBytes("UTF-8"),"ISO8859-1");
					resp.addHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
				} 
				
				IOUtils.copy(input, output);
				output.flush();
				output.close();
				input.close();
			}
			
			
		} else {
			// error
			resp.sendError(404, "参数异常");
		}
		
		
		
	}
	
}
