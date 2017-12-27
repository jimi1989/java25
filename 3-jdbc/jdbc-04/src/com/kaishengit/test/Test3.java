package com.kaishengit.test;

import com.kaishengit.dao.AccountDao;
import com.kaishengit.entity.Account;

public class Test3 {

	public static void main(String[] args) {
		
		AccountDao dao = new AccountDao();
		Account acc = dao.findById(2003);
		System.out.println(acc);
		
	}
	
}
