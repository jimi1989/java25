package com.kaishengit.web.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kaishengit.entity.Account;
import com.kaishengit.entity.Customer;
import com.kaishengit.exception.ForbiddenException;
import com.kaishengit.exception.ServiceException;
import com.kaishengit.service.AccountService;
import com.kaishengit.service.CustomerService;
import com.kaishengit.util.Config;
import com.kaishengit.web.BaseServlet;
@WebServlet("/customer/public/detail")
public class PublicCustomerDetailServlet extends BaseServlet{

	private static final long serialVersionUID = 1L;
	CustomerService custService = new CustomerService();
	AccountService accService= new AccountService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String custId = req.getParameter("id");
		try {
			Customer cust = custService.findCustomerById(custId,Config.PUBLIC_ID);
			List<Account> accList = accService.findAllAccount();
			req.setAttribute("customer", cust);
			req.setAttribute("accountList", accList);
			forward("customer/publicdetail", req, resp);
		} catch(ServiceException e) {
			resp.sendError(404,e.getMessage());
		} catch(ForbiddenException e) {
			resp.sendError(403,e.getMessage());
		}
		
		
	
	}
	
}