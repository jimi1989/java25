package com.kaishengit.entity;


public class Bank {

	private static Bank bank;
	
	private Bank(){}
	
	public static Bank getInstance() {
		if(bank == null) {
			bank = new Bank();
		}
		return bank;
	}
	
}
