package com.kaishengit.entity;

public class Student {

	private String name;

	public static int age;// 定义静态变量

	static {
		//静态代码快
		System.out.println("静态代码快执行...");
		age = 20;
		sayHello();
	}
	
	public static void sayHello() {
		System.out.println("student hello...");
		// sayHi();
		age = 40;
	}

	public void sayHi() {
		System.out.println("hi...");
		sayHello();
		System.out.println(age);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
