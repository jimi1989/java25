package com.kaishengit.test;

import java.util.List;

import com.kaishengit.dao.AccountDao;
import com.kaishengit.entity.Account;

public class DaoTest {

	public static void main(String[] args) {
		
		AccountDao dao = new AccountDao();
		
		Account acc = new Account();
		acc.setName("tom");
		acc.setPassword("123123");
		
		int id = dao.save(acc);
		System.out.println("id:" + id);
		
		/*Account acc = dao.findById(3005);
		
		acc.setName("tom.hanks");
		acc.setPassword("1qaz2wsx");
		
		System.out.println(acc);
		
		dao.update(acc);*/
		
//		dao.delete(3004);
		
		/*Account acc = dao.findById(3005);
		System.out.println(acc);*/
		
		/*Account acc = dao.findByNameAndPassword("tom", "1231234");
		if(acc != null) {
			System.out.println("µÇÂ¼³É¹¦");
		} else {
			System.out.println("µÇÂ¼Ê§°Ü");
		}*/
		
		/*List<Account> lists = dao.findAll();
		for (int i = 0; i < lists.size(); i++) {
			System.out.println(lists.get(i));
		}
		*/
		
	}

}
