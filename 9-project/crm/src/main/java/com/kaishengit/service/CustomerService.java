package com.kaishengit.service;

import java.util.Arrays;
import java.util.List;

import com.kaishengit.dao.CustomerDao;
import com.kaishengit.entity.Customer;
import com.kaishengit.util.Config;
import com.kaishengit.util.Page;

public class CustomerService {
	CustomerDao custDao = new CustomerDao();
	/**
	 * 新增客户是获得所有客户来源列表
	 * @return
	 */
	public List<String> findAllSources() {
		 String sourceStr = Config.get("customer.source");
		 String[] sourceArray = sourceStr.split(",");
		 return Arrays.asList(sourceArray);
	}
	
	/**
	 * 新增客户是获得所有客户行业列表
	 * @return
	 */
	public List<String> findAllTrades() {
		 String tradeStr = Config.get("customer.trade");
		 String[] tradeArray = tradeStr.split(",");
		 return Arrays.asList(tradeArray);
	}

	/**
	 * 
	 * 新增当前登录员工的客户信息
	 * @param custname
	 * @param sex
	 * @param jobtitle
	 * @param mobile
	 * @param source
	 * @param trade
	 * @param level
	 * @param mark
	 * @param id 当前登录员工的accountId
	 */
	public void addMyCustomer(String custname, String sex, String jobTitle,String address, String mobile, String source, String trade,
			String level, String mark, int accountId) {
		
		Customer customer = new Customer(custname, sex, jobTitle,address, mobile, trade, source, level, mark, accountId);
		customer.setReminder("员工添加");
		
		custDao.add(customer);
		
	}

	/**
	 * 根据accountId 和 pageNo查找对应的customer集合
	 * @param id
	 * @param pageNo
	 * @return 
	 */
	public Page<Customer> findMyCustomerByPage(int accountId, int pageNo) {
		int count = custDao.count(accountId);
		Page<Customer> page = new Page<>(count, pageNo);
		List<Customer> custList = custDao.findCustomerListByPage(accountId, page.getStart(), page.getPageSize());
		page.setItems(custList);
		return page;
	}

}
