package com.kaishengit.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class ArrayListTest {

	public static void main(String[] args) {
		
		//泛型集合 jdk7.0+ 钻石操作符
		List<String> strList = new Vector<>();
		List<Integer> intList = new ArrayList<>();
		
//		List<Student> stuList = new ArrayList<>();
		
		
		//add  jdk 5.0+
		strList.add("aa");
		strList.add("aa");
		strList.add("bb");
		strList.add("cc");
		strList.add(null);
		strList.add(null);
		
		strList.add(1, "yy");
		strList.set(5, "ww");
		
		strList.remove(6);
		
		System.out.println(strList.size());
		
		System.out.println(strList.indexOf("aa"));
		System.out.println(strList.lastIndexOf("aa"));
		
		System.out.println("-----------------------");
		
		List<String> subList = strList.subList(2, 4);
		
		
		
		//get
//		String str = strList.get(0);
//		System.out.println(str);
		
		//迭代集合
		/*for(int i = 0; i < strList.size(); i++){
			String str = strList.get(i);
			System.out.println(i + "--> " + str);
		}
		*/
		
		/*
		
		for(String str : strList) {
			System.out.println(str);
		}*/
		
		
		//迭代器
		Iterator<String> it = subList.iterator();
		while(it.hasNext()) {
			String str = it.next();
			System.out.println(str);
		}
		
		
		
		
		/*List list = new ArrayList();
		
		//add
		list.add(123);
		list.add("hello");
		list.add(true);
		list.add(123.456);
		
		//get
		String str = (String)list.get(1);*/
		
		
		
		
		
	}
	
}
