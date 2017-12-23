package com.kaishengit.test;

public class Thread1 extends Thread{

	@Override
	public void run() {
		// 线程运行时要做的事情
		for(int i = 0; i < 100; i++) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("thread1:" + i);
		}
	}
	
}
