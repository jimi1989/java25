package com.kaishengit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		String[] names = {"刘文龙","杜润民","周云辉","邱志辉","胥强","盛森","马志强","姜东","杨梦龙","杨冬冬","何九龙","周高祥","马得草","韩明晓","李晗","吕厚发","吴海涛"};
		List<String> list =  Arrays.asList(names);
		List<String> nameList = new ArrayList<>(list);
		List<String> newList = new ArrayList<>();
		for(int i = 0; i < list.size(); i++) {
			int index = (int)((names.length - i) * Math.random());
			String name = nameList.remove(index);
			newList.add(name);
		}
		
		for(String name : newList){
			System.out.println(name);
		}
		
	/*	int res = jiecheng(5);
		System.out.println(res);
		String password = "000000";
		System.out.println(Config.get("user.password.salt"));
		String md5Password = DigestUtils.md5Hex(password + Config.get("user.password.salt"));
		System.out.println(md5Password);*/
	}
	
	public static int jiecheng(int num) {
		if(num == 1) {
			return 1;
		} else {
			return num * jiecheng(num - 1);
		}
	}

}
