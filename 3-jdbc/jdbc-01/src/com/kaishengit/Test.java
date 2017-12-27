package com.kaishengit;

import com.kaishengit.entity.Account;

public class Test {

	public static void change(String s) {
		s = "123";
	}
	
	public static void change(Account s) {
		s.setName("234");;
	}
	
	public static void main(String[] args) {

		String str = new String("aaa");
		String s = str;
		s = "bbb";
		
//		Test.change(str);
		System.out.println(str);
		
		/*Account acc = new Account();
		Test.change(acc);
		Account acc1 = acc;
		acc1.setName("123");
		System.out.println(acc);*/
	}

}
