package com.kaishengit.test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

import com.kaishengit.util.StringUtil;

public class Test {

	public static void main(String[] args) {
//
//		int[] nums = {};
//		System.out.println(nums.length);  
//		String  length()
//		List  size()
		
		/*System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MAX_VALUE + 1);*/
		
		/*double res = 2.0 - 1.1;
		System.out.println(res);*/
		
		BigDecimal bd = new BigDecimal("5");
		BigDecimal bd2 = new BigDecimal("2");
		System.out.println(bd.divide(bd2));
		
		
		/*BigDecimal bd = new BigDecimal("2.0");
		BigDecimal bd2 = new BigDecimal("1.1");
		System.out.println(bd.subtract(bd2));*/
		
		/*BigInteger bi = new BigInteger("21474836475");
		BigInteger bi2 = new BigInteger("65246436436");
//		BigInteger res = bi.add(bi2);
		BigInteger res = bi.multiply(bi2);
		System.out.println(res);*/
		
		
		/*String bankNo = "6222-0217-0344-987";
		String regex = "(\\d{4}-){3}\\d{3}";
		System.out.println(bankNo.matches(regex));*/
		
		/*String tel = "13898773662";
		String regex = "1[3578]{1}\\d{9}";
		System.out.println(tel.matches(regex));*/
		
		
		
//		正则表达式
//		String str = "123asd_SDF";
//		String regex = "\\w+";
		
		
//		String str = "1234a5";
//		String regex = "\\d+"; // [0-9]
//		String regex = "\\D+"; // [^0-9]
		
		
//		String regex = "a{3}b{2,4}c{2,}";
//		String str = "bbbbbbb";
//		String regex = "a?b*c+";
//		String regex = "[a-z]+";
//		String regex = "[^0-9A-z]+";
//		String str = "$中国%";
		
		
		
//		System.out.println(str.matches(regex));
		
//		String idCard = "41052119950619554X";
//		System.out.println(StringUtil.getBornYear(idCard));
//		System.out.println(StringUtil.getSex(idCard));
		
//		System.out.println(StringUtil.isEmail("tom@163.com"));
		
//		System.out.println(StringUtil.isNotEmpty("asd"));
		
		
//		String str = "1234a5";
//		boolean res = StringUtil.isNumber(str);
//		System.out.println(res);
		
		
		
		/*String name = "aabbcc";
		String regex = "a[2||4]b{2}c{2}";
		System.out.println(name.matches(regex));*/
		
		
		/*String article = "what a nice day";
		System.out.println(article.substring(5,11)); //　截取时包含前面不包含后面
		
		System.out.println(article.toUpperCase());
		
		System.out.println(String.valueOf(123));*/
		
		/*String name = "tom,jack,rose,lebron,paul";
		String[] names = name.split(",");
		
		for(int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
		}*/
		
//		String name = "fuck,jack";
//		System.out.println(name.replace("fuck","f**k"));
//		
//		String name = "       j a    c k       ";
//		System.out.println(name.trim());
//		System.out.println(name.replace(" ", ""));
		
//		String str = "a";
//		System.out.println(str.length());
//		System.out.println(str.isEmpty());
		
		
//		String str = "jackhahahajackjack";
//		System.out.println(str.indexOf("w"));
//		System.out.println(str.lastIndexOf("w"));
		
		
		
//		String name = "jack";
//		System.out.println(name.equalsIgnoreCase("JACK"));
		
		
		
//		String url = "www.google.cn";
//		System.out.println(url.startsWith("www"));
//		System.out.println(url.endsWith(".com"));
		
		
//		String article = "出售木*仓*木*支弹药,电话:110";
//		System.out.println(article.contains("枪支") || article.contains("木仓木支"));
		
//		String str = "abcdefg";
//		
//		System.out.println(str.contains("abc"));
//		
		
//		str = str.concat("xyz");//　str + "xyz";
//		System.out.println(str);
		
//		String otherStr = "Abcdefg";
//		int res = str.compareToIgnoreCase(otherStr);
//		System.out.println(res);
		
		
//		int num = str.codePointAt(1);
//		System.out.println(num);
		
		
		/*
		char ch = str.charAt(4);
		System.out.println(ch);
		*/
		
		/*	char[] chars = {'j','a','c','k'};
		String name = new String(chars);
		System.out.println(name);*/
		
		
//		String str = new String("abc"); // 空字符串
//		String str1 = new String("abc");
//		System.out.println(str == str1); false
//		
//		String str = "abc";
//		String str1 = "abc";
//		System.out.println(str == str1); //true
		
//		Integer in = 12;
//		Integer in2 = 12;
//		System.out.println(in == in2);
		
//		Long l = 128L;
//		Long l1 = 128L;
//		System.out.println(l == l1);
		
//		Double d = 123.123;
//		Double d1 = 123.123;
//		System.out.println(d == d1);
		
		
		
		
//		String str1 = null; //null
//		System.out.println(str);
		
		
		
//		String str = "abc";
//		StringBuffer buffer = new StringBuffer("abc");
		/*StringBuilder builder = new StringBuilder("abc");
		
		//获取从1970年1月1日0时0分0秒到当前时间的毫秒数
		long startTime = System.currentTimeMillis();
		
		for(int i = 0; i< 50000; i++){
//			str += i;
//			buffer.append(i);
			builder.append(i);
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("共花费" + (endTime - startTime) + "ms");
		System.out.println("the end!");*/
		
		/*String str = "abc";
		str = "jack";
		str = "tom";*/
		
	}

}
