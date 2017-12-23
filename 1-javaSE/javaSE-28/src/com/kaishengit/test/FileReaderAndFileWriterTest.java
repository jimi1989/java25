package com.kaishengit.test;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderAndFileWriterTest {

	public static void main(String[] args) throws IOException {
		
		/*FileWriter writer = new FileWriter("d:/data.txt",true);
		writer.write("12314341324");
		writer.write("312546563547");
		writer.flush();
		writer.close();*/
		
		FileReader reader = new FileReader("d:/data.txt");
		char[] buffer = new char[100];
		int len = -1;
		StringBuilder builder = new StringBuilder();
		while((len = reader.read(buffer)) != -1) {
			builder.append(buffer, 0, len);
		}
		
		System.out.println(builder.toString());
		
		reader.close();
		
		
	}
	
}
