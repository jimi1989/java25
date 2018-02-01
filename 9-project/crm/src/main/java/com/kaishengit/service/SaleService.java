package com.kaishengit.service;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.kaishengit.dao.CustomerDao;
import com.kaishengit.dao.SaleDao;
import com.kaishengit.dao.SaleRecordDao;
import com.kaishengit.entity.Customer;
import com.kaishengit.entity.SaleChance;
import com.kaishengit.entity.SaleChanceRecord;
import com.kaishengit.exception.ForbiddenException;
import com.kaishengit.exception.ServiceException;
import com.kaishengit.util.Config;
import com.kaishengit.util.Page;

public class SaleService {

	CustomerDao custDao = new CustomerDao();
	SaleDao saleDao = new SaleDao();
	SaleRecordDao saleRecordDao = new SaleRecordDao();
	/**
	 * 获得销售机会的进度列表
	 * @return
	 */
	public List<String> findAllProcess() {
		String processString = Config.get("sales.progress");
		String[] processArray = processString.split(",");
		return Arrays.asList(processArray);
	}

	/**
	 * 获得当前登录员工的所有客户列表
	 * @param accountId
	 * @return
	 */
	public List<Customer> findAllCustomersByAccountId(int accountId) {
		return custDao.findByAccountId(accountId);
	}

	public void saveSaleChane(SaleChance saleChance) {
		// 修改customer表中last_concat_time
		Customer cust = custDao.findById(saleChance.getCustId());
		cust.setLastConcatTime(new Timestamp(System.currentTimeMillis()));
		custDao.update(cust);
		
		// 保存销售机会
		saleChance.setLastTime(new Timestamp(System.currentTimeMillis()));
		int saveId = saleDao.save(saleChance);
		
		// 如果填写了content，那么需要在sale_chance_record表中添加记录
		if(StringUtils.isNotEmpty(saleChance.getContent())) {
			SaleChanceRecord record = new SaleChanceRecord();
			record.setContent(saleChance.getContent());
			record.setSaleId(saveId);
			saleRecordDao.save(record);
		}
		
	}

	/**
	 * 根据accountId获得对应员工的销售机会列表的page对象
	 * @param pageNo 页码
	 * @param accountId 员工id
	 * @return page
	 */
	public Page<SaleChance> findSaleListByPage(int pageNo, int accountId) {
		// 获得总条数
		int count = saleDao.countByAccountId(accountId);
		Page<SaleChance> page = new Page<>(count, pageNo);
		List<SaleChance> saleChanceList = saleDao.findListByAccountIdAndPage(accountId,page.getStart(), page.getPageSize());
		page.setItems(saleChanceList);
		return page;
	}

	/**
	 * 根据id查找saleChance对象
	 * @param saleId
	 * @return
	 */
	public SaleChance findSaleChanceById(String saleId,int accountId) {
		
		SaleChance saleChance = checkSaleChance(saleId,accountId);
		
		return saleChance;
	}

	/**
	 * 1.判断saleid是否为纯数字
	 * 2.判断seleid是否合法，是否存在对应的saleChance对象
	 * 3.当前登录员工是否有查看该销售机会详情的权限
	 * @param saleId
	 * @return
	 */
	private SaleChance checkSaleChance(String saleId,int accountId) {
		if(!StringUtils.isNumeric(saleId)) {
			throw new ServiceException("参数异常");
		}
		
		SaleChance saleChance = saleDao.findById(saleId);
		if(saleChance == null) {
			throw new ServiceException("参数异常");
		}
		
		if(saleChance.getAccountId() == accountId) {
			return saleChance;
		} else {
			throw new ForbiddenException("拒绝访问");
		}
		
	}

	public List<SaleChanceRecord> findRecordListBySaleId(String saleId) {
		return saleRecordDao.findListBySaleId(saleId);
	}


}