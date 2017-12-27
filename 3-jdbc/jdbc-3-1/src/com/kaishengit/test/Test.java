package com.kaishengit.test;

import java.util.List;

import com.kaishengit.dao.AccountDao;
import com.kaishengit.entity.Account;

public class Test {

	public static void main(String[] args) {

		/*List lists = new ArrayList();
		lists.add("123");
		lists.add(123);
		
		lists.get(0);
		*/
		
		/*UserDao dao = new UserDao();
		User user = dao.findById(2);
		System.out.println(user);*/
		
		AccountDao accDao = new AccountDao();
		/*Account acc = accDao.findById(3005);
		System.out.println(acc);*/
		
		List<Account> lists = accDao.findAll();
		for(Account acc : lists) {
			System.out.println(acc);
		}
		
		
	}

}
