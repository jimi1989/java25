package com.kaishengit.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		
		/*List<String> strList = Collections
				.synchronizedList(new ArrayList<String>());
		
		Set<String> strSet = Collections
				.synchronizedSet(new HashSet<String>());
		
		Map<String,String> maps = Collections
				.synchronizedMap(new HashMap<String,String>());
		*/
		
		Account account = new Account();
		
		Boy boy = new Boy(account);
		boy.start();
		
		Girl girl = new Girl(account);
		girl.start();
		
		/*Thread1 th1 = new Thread1();
		//标记为守护线程
		th1.setDaemon(true);
		th1.start();*/
		
		/*Thread2 th2 = new Thread2();
		Thread th = new Thread(th2);
		th.start();*/
		
		/*try {
			for (int i = 0; i < 100; i++) {
				Thread.sleep(30);
				if(i == 20) {
					Thread1 th1 = new Thread1();
					th1.start();
					th1.join();//标记成join线程
				}
				
				System.out.println("main:" + i);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		
		
	}
	
}
