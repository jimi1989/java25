package com.kaishengit.test;

public class Girl extends Thread{

	private Account acc;
	
	public Girl(Account acc) {
		this.acc = acc;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		acc.pickMoney("rose", 9000);
	}
	
}
