package com.kaishengit.web.disk;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kaishengit.entity.Disk;
import com.kaishengit.service.DiskService;
import com.kaishengit.util.AjaxResult;
import com.kaishengit.web.BaseServlet;

@WebServlet("/disk/md5")
public class DiskFileMd5Servlet extends BaseServlet{

	private static final long serialVersionUID = 1L;

	DiskService service = new DiskService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String md5 = req.getParameter("md5");
		String pid = req.getParameter("pid");
		String name = req.getParameter("name");
		System.out.println(md5);
		Disk disk = service.findDiskByMd5(md5);
		if(disk == null){
			sendJson(AjaxResult.success(), resp);
		} else {
			name = new String(name.getBytes("ISO8859-1"),"UTF-8");
			disk.setName(name);
			disk.setpId(Integer.parseInt(pid));
			disk.setAccountId(getCurrAccount(req).getId());
			service.saveFile(disk);
			sendJson(AjaxResult.error("该文件已存在"), resp);
		}
	}
	
}
