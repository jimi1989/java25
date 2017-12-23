package com.kaishengit.util;

public class StringUtil {

	/**
	 * 判断参数字符串是否为纯数字
	 * @param str 需要判断的字符串
	 * @return ture:纯数字  false:非纯数字
	 */
	public static boolean isNumber(String str) {
		
		String regex = "\\d+";
		
		// 判空处理
		if(isEmpty(str)){
			return false;
		}
		
		return str.matches(regex);
		
		
		/*char[] chars = str.toCharArray();
		
		for(int i = 0; i< chars.length; i++) {
			char ch = chars[i];
			if(!Character.isDigit(ch)) {
				return false;
			}
		}
		
		return true;*/
		
		/*// 判空处理
		if(str == null || str.isEmpty()){
			return false;
		}
		
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);// 获得对应索引的字符
//			if(!(ch >= 48 && ch <=57)) {
//			if(ch < 48 || ch > 57) {
			if(ch < '0' || ch > '9') {
				return false;
			}
		}
		return true;*/
		
	}
	
	
	
	/**
	 * 判断参数字符串格式是否为email
	 * @param str 要参与判断的字符串
	 * @return true:email格式正确  false：email格式错误
	 */
	public static boolean isEmail(String str) {
		// 4567892@qq.com
		// jimi_jin123@163.com
		// zhangsan@ligong.edu.cn
		
		if(isEmpty(str)) {
			return false;
		}
		
//		String regex = "\\w+@\\w+(.\\w+){1,2}";// .com   .com.cn
		return str.matches("\\w+@\\w+(\\.\\w+){1,2}");
		
		
		/*
		// 判断@ .的位置
		int atIndex = str.indexOf("@");
		int dotIndex = str.indexOf(".");
		
		// 如果str中不存在@或者. return false
		if(atIndex == -1 || dotIndex == -1) {
			return false;
		}
		
		// 如果@是第一位或者最后一位，返回false
		if(atIndex == 0 || atIndex == str.length() -1) {
			return false;
		}
		//	如果.是第一位或者最后一位，返回false
		if(dotIndex == 0 || dotIndex == str.length() -1) {
			return false;
		}
		
		// .在@之前 返回false
		if(dotIndex - atIndex < 2) {
			return false;
		} 
		
		// 判断不能有两个@，判断indexOf()和lastindexOf()是否相等，不相等证明有两个以上@符号
		int lastAtIndex = str.lastIndexOf("@");
		if(atIndex != lastAtIndex) {
			return false;
		}
		
		// .只能有一个或者两个，不能更多
		String[] strs = str.split("\\.");//？将正则表达式中.（任意字符）的特性去掉
		if(strs.length > 3) {
			return false;
		}

		// 如果有两个.，那么这两个.不能相邻
		int lastDotIndex = str.lastIndexOf(".");
		if(lastDotIndex - dotIndex == 1) {
			return false;
		}
		
		return true;*/
	}
	
	/**
	 * 判断字符串是否为null或者空字符串
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.isEmpty();
	}
	
	
	/**
	 * 判断字符串是否不为null和空字符串
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
//		return str != null && !str.isEmpty();
		return !isEmpty(str);
	}
	
	/**
	 * 根据身份证获得用户的出生年份
	 * @param idCard 身份证
	 * @return 出生年分
	 */
	public static String getBornYear(String idCard) {
		String year = idCard.substring(6, 10);
		return year;
	}
	
	
	/**
	 * 根据身份证号码获得用户的性别
	 * @param idCard
	 * @return 性别
	 */
	public static String getSex(String idCard) {
		String sex = idCard.substring(idCard.length() - 2, idCard.length() - 1);
		int sexNum = Integer.parseInt(sex);
		if(sexNum % 2 == 0) {
			return "woman";
		} else {
			return "man";
		}
	}
	
}
