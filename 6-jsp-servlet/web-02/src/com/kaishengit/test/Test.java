package com.kaishengit.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	public static void main(String[] args) {

		long time = 1515398981614L;
		Date date = new Date(time);
		System.out.println(date);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formatDate = df.format(date);
		System.out.println(formatDate);
		
	}

}
