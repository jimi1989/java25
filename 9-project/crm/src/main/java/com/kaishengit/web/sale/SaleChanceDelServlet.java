package com.kaishengit.web.sale;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kaishengit.exception.ForbiddenException;
import com.kaishengit.exception.ServiceException;
import com.kaishengit.service.SaleService;
import com.kaishengit.web.BaseServlet;

@WebServlet("/sale/del")
public class SaleChanceDelServlet extends BaseServlet{

	private static final long serialVersionUID = 1L;
	SaleService saleService = new SaleService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String saleId = req.getParameter("saleId");
		int accountId = getCurrAccount(req).getId();
		try {
			saleService.delBySaleId(saleId, accountId);
			resp.sendRedirect("/sale/my/list");
			
		} catch(ServiceException e) {
			resp.sendError(404,e.getMessage());
		} catch(ForbiddenException e) {
			resp.sendError(403,e.getMessage());
		}
		
	}
	
	
}
