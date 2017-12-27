package com.kaishengit.test;

import com.kaishengit.dao.AccountDao;
import com.kaishengit.entity.Account;

public class Test {

	public static void main(String[] args) {

		/*List lists = new ArrayList();
		lists.add("123");
		lists.add(123);
		
		lists.get(0);
		*/
		
		AccountDao dao = new AccountDao();
		Account acc = dao.findById(3005);
		System.out.println(acc);
		
	}

}
