package com.kaishengit.util;

import java.io.IOException;
import java.util.Properties;

public class Config {
	public static final int COMPANY_ID = 1;
	
	private static Properties prop = new Properties();
	static {
		try {
			prop.load(Config.class.getClassLoader().getResourceAsStream("config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String get(String key) {
		return prop.getProperty(key);
	}
	
}
