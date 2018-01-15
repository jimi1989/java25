package com.kaishengit.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.codec.digest.DigestUtils;

public class Test {

	public static void main(String[] args) throws IOException {
		
		
//		Properties prop = new Properties();
//		prop.setProperty("aa", "bb");
//		
//		System.out.println(prop.getProperty("aa"));
		
		Properties prop = new Properties();
		prop.load(Test.class.getClassLoader().getResourceAsStream("config.properties"));
		
		System.out.println(prop.getProperty("jdbc.driver"));
		
		/*InputStream in1 = new FileInputStream("d:/1.txt");
		InputStream in2 = new FileInputStream("d:/2.txt");
		
		String code1 = DigestUtils.md5Hex(in1);
		String code2 = DigestUtils.md5Hex(in2);
		// 文件内容校验
		System.out.println(code1.equals(code2));*/
		
//		String password = "123123";
//		String salt = "#$@#DFSA^%$#asdfas^%^";
////		String code = DigestUtils.md5Hex("");
//		String code = DigestUtils.md5Hex(DigestUtils.md5Hex(password) + salt);
////		String code = DigestUtils.sha512Hex("1231dfdssaf23");
//		System.out.println(code);
		
		
		
		
		// 4297f44b13955235245b2497399d7a93
		// f325c58eb78388add10a1eb25670bd7b
		// 4297f44b13955235245b2497399d7a93
		// 601f1889667efaebb33b8c12572835da3f027f78	
		// 96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e
		// 263fec58861449aacc1c328a4aff64aff4c62df4a2d50b3f207fa89b6e242c9aa778e7a8baeffef85b6ca6d2e7dc16ff0a760d59c13c238f6bcdc32f8ce9cc62
		// f028c2eee4926b943b3dd191b0eb2ba51b6615303e0156b90433bdac7fe185a6b106d64c2fbc8190e6a4cc8cef8493ce3dec84abde2776480f2858277cca65ac

		/*UUID uuid = UUID.randomUUID();
		System.out.println(uuid);*/
		/*long time = 1515398981614L;
		Date date = new Date(time);
		System.out.println(date);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formatDate = df.format(date);
		System.out.println(formatDate);
		*/
	}

}
