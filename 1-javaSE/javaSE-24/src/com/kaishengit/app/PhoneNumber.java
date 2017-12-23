package com.kaishengit.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class PhoneNumber {

	Scanner input = new Scanner(System.in);
	
	Map<String, String> maps = new HashMap<>(); 
	
	public void startup() {
		
		System.out.println("欢迎使用电话号码本：");
		System.out.println("1. 添加");
		System.out.println("2. 通过电话查询联系人");
		System.out.println("3. 通过联姓名查询电话");
		System.out.println("4. 通过电话删除联系人");
		System.out.println("5. 通过姓名删除联系人");
		System.out.println("6. 退出");
		System.out.println("请选择：");

		int index = input.nextInt();
		if(1 == index) {
			save();
		} else if(2 == index) {
			findByTel();
		} else if(3 == index) {
			findByName();
		} else if(4 == index) {
			removeByTel();
		} else if(5 == index) {
			removeByName();
		} else if(6 == index) {
			System.exit(0);
		} else {
			System.out.println("输入错误，请重新输入");
		} 
		startup();
		
	}

	/**
	 * 根据姓名删除联系人
	 */
	private void removeByName() {
		System.out.println("请输入联系人姓名：");
		String name = input.next();
		
		List<String> telList = new ArrayList<>();
		
		Set<Entry<String,String>> entrys =  maps.entrySet();
		
		for(Entry<String,String> entry : entrys) {
			if(name.equals(entry.getValue())) {
				telList.add(entry.getKey());
			}
		}
		
		if(telList.size() > 0) {
			for(String tel : telList) {
				maps.remove(tel);
			}
			System.out.println("删除成功!");
		} else {
			System.out.println("查无此人");
		}
		
	}

	/**
	 * 通过姓名查找
	 */
	private void findByName() {
		
		System.out.println("请输入联系人姓名：");
		String name = input.next();
		
		List<String> telList = new ArrayList<>();
		
		Set<Entry<String,String>> entrys =  maps.entrySet();
		
		for(Entry<String,String> entry : entrys) {
			if(name.equals(entry.getValue())) {
				telList.add(entry.getKey());
			}
		}
		
		if(telList.size() > 0) {
			for(String tel : telList) {
				System.out.println(name + "的电话号码为：" + tel);
			}
		} else {
			System.out.println("查无此人");
		}
		
	}

	/**
	 * 根据电话号码删除对应的联系人
	 */
	private void removeByTel() {
		System.out.println("请输入电话");
		String phoneNo = input.next();
		
		String name = maps.get(phoneNo);
		
		if(name == null) {
			System.out.println("该联系人不存在");
		} else {
			maps.remove(phoneNo);
			System.out.println("删除成功!");
		}
	}

	/**
	 * 查找（根据电话号码查找联系人姓名）
	 */
	private void findByTel() {
	
		System.out.println("请输入电话");
		String phoneNo = input.next();
		
		String name = maps.get(phoneNo);
		
		if(name == null) {
			System.out.println("查无此人");
		} else {
			System.out.println("该联系人为：" + name);
		}
		
	}

	/**
	 * 保存电话号码
	 */
	private void save() {
		System.out.println("请输入电话号码：");
		String phoneNo = input.next();
		
		if(maps.containsKey(phoneNo)) {
			System.out.println("该电话号码已存在，请重新输入");
		} else {
			System.out.println("请输入联系人姓名：");
			String name = input.next();
			
			maps.put(phoneNo, name);
			System.out.println("保存成功！");
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
