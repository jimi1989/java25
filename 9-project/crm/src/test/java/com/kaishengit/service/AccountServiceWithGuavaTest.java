package com.kaishengit.service;

import org.junit.Test;

import com.kaishengit.entity.Account;

public class AccountServiceWithGuavaTest {

	AccountServiceWithGuava service = new AccountServiceWithGuava();
	
	@Test
	public void findByIdTest() {
		Account acc = service.findById(15);
		service.findById(15);
		System.out.println(acc.getUsername());
	}
	
}
