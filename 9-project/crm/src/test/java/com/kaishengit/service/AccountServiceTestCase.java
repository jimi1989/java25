package com.kaishengit.service;

import java.util.List;

import org.junit.Test;

import com.kaishengit.entity.Account;

public class AccountServiceTestCase {

	AccountService service = new AccountService();
//	AccountDao accDao = new AccountDao();
	
	@Test
	public void findALlTest(){
		List<Account> accList = service.findAllAccount();
		service.findAllAccount();
		System.out.println(accList.size());
	}
	
	@Test
	public void findByIdTest() {
		
		int accountId = 15;
		
		Account acc = service.findById(accountId);
		service.findById(15);
		
		System.out.println(acc.getUsername());
		
		
		
		/*CacheManager cacheManage = new CacheManager();
		Ehcache cache = cacheManage.getEhcache("account");
		Account acc = accDao.findById(15);
		Element element = new Element(acc.getId(), acc); // 元素
		// 放入缓存
		cache.put(element); 
		
		// 从缓存中删除
//		cache.remove(15);
		cache.removeAll();
		
		// 从缓存中取值，结果为Element
		Element ele = cache.get(15);
//		cache.get(15);
		Account account = (Account)ele.getObjectValue();
		System.out.println(account.getUsername());*/
	}
	
}
