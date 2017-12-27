package com.kaishengit.test;

import java.util.List;

import com.kaishengit.dao.AccountDao;
import com.kaishengit.dao.UserDao;
import com.kaishengit.entity.Account;
import com.kaishengit.entity.User;

public class DaoTest {

	public static void main(String[] args) {
		
		AccountDao accountDao = new AccountDao();
		
		/*Account acc = new Account();
		acc.setName("jack");
		acc.setPassword("123123");
		
		accountDao.save(acc);*/
		
		/*Account acc = accountDao.findById(3006);
		acc.setPassword("123456");
		
		accountDao.update(acc);*/
		
//		accountDao.delete(3006);
		
		/*Account acc = accountDao.findById(3005);
	
		System.out.println(acc);*/

		Account acc = accountDao.findByNameAndPassword("jack", "123123");
		System.out.println(acc);
		
		/*List<Account> lists = accountDao.findAll();
		
		for(Account acc : lists) {
			System.out.println(acc);
		}*/
		
		
		/*UserDao userDao = new UserDao();
		User user = userDao.findById(2);
		System.out.println(user);*/
		
	}

}
