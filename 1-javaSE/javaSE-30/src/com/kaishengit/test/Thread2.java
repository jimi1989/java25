package com.kaishengit.test;

public class Thread2 implements Runnable{

	@Override
	public void run() {
		//线程运行时做的事情
		for(int i = 0; i < 100; i++) {
			System.out.println("thread2:" + i);
		}
	}

}
