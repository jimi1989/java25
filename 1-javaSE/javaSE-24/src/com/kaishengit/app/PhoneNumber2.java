package com.kaishengit.app;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneNumber2 {

	Scanner input = new Scanner(System.in);
	
	Map<String, String> maps = new HashMap<>(); 
	
	public void startup() {
		
		System.out.println("欢迎使用电话号码本：");
		System.out.println("1. 添加");
		System.out.println("2. 查询");
		System.out.println("3. 删除");
		System.out.println("4. 退出");
		System.out.println("请选择：");

		int index = input.nextInt();
		if(1 == index) {
			save();
		} else if(2 == index) {
			find();
		} else if(3 == index) {
			remove();
		} else if(4 == index) {
			System.exit(0);
		} else {
			System.out.println("输入错误，请重新输入");
		} 
		startup();
		
	}

	/**
	 * 根据电话号码删除对应的联系人
	 */
	private void remove() {
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
	private void find() {
	
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
