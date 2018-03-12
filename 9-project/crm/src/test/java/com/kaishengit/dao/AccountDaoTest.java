package com.kaishengit.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Timestamp;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.kaishengit.entity.Account;

public class AccountDaoTest {
	private AccountDao accDao = null;
	
	@Before
	public void before() {
		// ...
		accDao = new AccountDao();
	}
	
	@Test
	public void saveTest() {
		
		Account acc = new Account();
		acc.setUsername("junit");
		acc.setPassword("000000");
		acc.setMobile("195");
		acc.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		
		accDao.save(acc);
		
	}
	
	@Test
	public void findByIdTest() {
		int accountId = 15;
		Account acc = accDao.findById(accountId);
		
		// 断言机制
		assertNotNull(acc);
	}
	
	@Test
	public void findAll() {
		List<Account> accList = accDao.findAll();
		assertEquals(14,accList.size());
	}
	
	
	@After
	public void after(){
		System.out.println("单元测试已通过，请查看结果");
	}
}
