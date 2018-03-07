package com.kaishengit.web.chart;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kaishengit.service.CustomerService;
import com.kaishengit.util.AjaxResult;
import com.kaishengit.web.BaseServlet;

@WebServlet("/charts/level/count")
public class ChartsLevelCountServlet extends BaseServlet{

	private static final long serialVersionUID = 1L;
	
	CustomerService service = new CustomerService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Map<String,Object>> mapsList = service.countCustomerLevel();
		AjaxResult result = AjaxResult.success(mapsList);
		sendJson(result, resp);
	}
	
}
