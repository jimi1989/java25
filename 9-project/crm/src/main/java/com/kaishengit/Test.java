package com.kaishengit;

import org.apache.commons.codec.digest.DigestUtils;

import com.kaishengit.util.Config;

public class Test {

	public static void main(String[] args) {
		int res = jiecheng(5);
		System.out.println(res);
		/*String password = "000000";
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
