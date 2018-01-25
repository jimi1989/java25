package com.kaishengit;

import org.apache.commons.codec.digest.DigestUtils;

import com.kaishengit.util.Config;

public class Test {

	public static void main(String[] args) {
		String password = "000000";
		System.out.println(Config.get("user.password.salt"));
		String md5Password = DigestUtils.md5Hex(password + Config.get("user.password.salt"));
		System.out.println(md5Password);
	}

}
