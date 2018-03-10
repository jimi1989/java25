package com.kaishengit.web.disk;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kaishengit.exception.ServiceException;
import com.kaishengit.service.DiskService;
import com.kaishengit.web.BaseServlet;

@WebServlet("/disk/delete")
public class DiskDeleteServlet extends BaseServlet{

	private static final long serialVersionUID = 1L;

	DiskService service = new DiskService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		try{
			int pid = service.deleteDiskById(id);
			resp.sendRedirect("/disk/home?pid=" + pid);
		} catch(ServiceException e) {
			resp.sendError(404);
		}
	}
	
}
