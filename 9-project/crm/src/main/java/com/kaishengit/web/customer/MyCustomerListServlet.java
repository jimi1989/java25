package com.kaishengit.web.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.kaishengit.entity.Account;
import com.kaishengit.entity.Customer;
import com.kaishengit.service.CustomerService;
import com.kaishengit.util.Page;
import com.kaishengit.web.BaseServlet;

@WebServlet("/customer/my/list")
public class MyCustomerListServlet extends BaseServlet{

	private static final long serialVersionUID = 1L;

	CustomerService service = new CustomerService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String p = req.getParameter("p");
		
		int pageNo = 1;
		if(StringUtils.isNumeric(p)) {
			pageNo = Integer.parseInt(p);
		}
		Account acc = getCurrAccount(req);
	
		Page<Customer> page = service.findCustomerByPage(acc.getId(),pageNo);
		
		req.setAttribute("page", page);
		
		forward("customer/mylist", req, resp);
		
		
	}
	
}
