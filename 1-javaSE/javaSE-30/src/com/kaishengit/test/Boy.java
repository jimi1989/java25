package com.kaishengit.test;

public class Boy extends Thread{

	private Account acc;
	
	public Boy(Account acc) {
		this.acc = acc;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		acc.pickMoney("jack", 9000);
	}
	
}
