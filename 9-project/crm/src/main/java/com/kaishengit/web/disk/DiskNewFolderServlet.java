package com.kaishengit.web.disk;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.kaishengit.service.DiskService;
import com.kaishengit.util.AjaxResult;
import com.kaishengit.web.BaseServlet;

@WebServlet("/disk/new/folder")
public class DiskNewFolderServlet extends BaseServlet{

	private static final long serialVersionUID = 1L;
	
	DiskService service = new DiskService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String pid = req.getParameter("pid");
		
		int pId = 0;
		if(StringUtils.isNumeric(pid)) {
			pId = Integer.parseInt(pid);
		}
		try {
			int accountId = getCurrAccount(req).getId();
			service.saveDiskDir(name, pId, accountId);
			sendJson(AjaxResult.success(), resp);
		} catch(NullPointerException e) {
			sendJson(AjaxResult.error("登录过期，请重新登录"), resp);
		}
		
	}
	
}
