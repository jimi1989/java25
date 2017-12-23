package com.kaishengit.test;

import com.kaishengit.entity.Student;

public class Test {

	public static void main(String[] args) {
		
		Student stu = new Student();
		stu.setAge(10);
		stu.setName("tom");
//		System.out.println(stu.toString());
		
		Student stu2 = new Student();
		stu2.setAge(10);
		stu2.setName("tom");
		
		System.out.println(stu.equals(stu2));
		
		
		/*Integer in = new Integer(20);
		Integer in2 = 20;
		System.out.println(in == in2);*/
		
		/*Integer in = 1208;
		Integer in2 = 1208;
		System.out.println(in.equals(in2));*/
		
		//Integer --> double
//		Integer in = 56789;
//		double d = in.doubleValue();
//		System.out.println(d);
		
//		Integer in = 78945;
//		double d1 = in;
//		System.out.println(d1);
		
		
		// String -- > int
//		int num = Integer.parseInt("456");
//		System.out.println(num);
		
//		int num = Integer.valueOf("456a");
		
		
		// int --> String
//		String str = Integer.toString(789);
//		System.out.println(str);
		
		
		
		// Integer --> String
		/*Integer in = 123;
		String str = in.toString();
		System.out.println(str);*/
		
		
		// Integer --> int
		/*Integer in = new Integer(235);
		int num = in;
		
//		int num = in.intValue();
		System.out.println(num);*/
		
		
		//String -- > Integer
		/*Integer in = new Integer("234a");
		System.out.println(in);*/
		
		// int -- > Integer
//		int num = 12; //×Ô¶¯×°Ïä autoBoxing jdk 5.0+
//		Integer in = 56;
//		System.out.println(in);
		
		/*Integer in = new Integer(123);
		System.out.println(in);*/
		
//		System.out.println(Integer.MAX_VALUE);
//		System.out.println(Integer.MIN_VALUE);
		
//		int num = 123;
//		String numStr = num + "";
//		
		
	}
	
}
