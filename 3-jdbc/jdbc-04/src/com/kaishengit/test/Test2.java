package com.kaishengit.test;

import java.lang.reflect.Method;

import com.kaishengit.entity.Account;

public class Test2 {

	public static void main(String[] args) throws Exception{
//		// ·´Éä»úÖÆ
		
		Class clazz = Account.class;
		
		Object obj = clazz.newInstance();
		
//		System.out.println(obj instanceof Account);
		
//		Account account = new Account();
//		Class clazz = account.getClass();//Account.class;//Class.forName("com.kaishengit.entity.Account");
		
		
//		clazz.getMethod("sayHello");
		Method method = clazz.getMethod("sayHello",String.class);
//		System.out.println(method.getName());
		
		method.invoke(obj, "jack");
		
		/*Method[] methods = clazz.getMethods();
		
		for(Method method : methods) {
			System.out.println(method.getName());
		}*/
		
		
	}
	
}
