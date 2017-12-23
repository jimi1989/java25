package com.kaishengit.test;

import java.util.HashMap;
import java.util.Map;

import com.kaishengit.exception.NameEmptyException;
import com.kaishengit.exception.TelEMptyException;

public class PhoneNumber {

	Map<String, String> maps = new HashMap<>();

	public void findByName(String name) throws NullPointerException, NameEmptyException {
		if (name == null) {
			throw new NullPointerException("name不能为null");
		}

		if ("".equals(name.trim())) {
			throw new NameEmptyException("name不能为空字符串");
		}

		System.out.println("hello");

	}

	public void findByTel(String tel) throws TelEMptyException{
		if("".equals(tel.trim())) {
			throw new TelEMptyException("tel不能为空");
		}
		
		System.out.println("end");
	}
	
}
