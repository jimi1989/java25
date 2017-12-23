package com.kaishengit.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedWriterAndReaderTest {

	public static void main(String[] args) {

		try {
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(new FileInputStream("d:/data.txt")));
			
			String str = null;
			StringBuilder builder = new StringBuilder();
			while((str = reader.readLine()) != null) {
				builder.append(str).append("\n");
//				System.out.println(str);
			}
			System.out.println(builder.toString());
			reader.close();
			
			/*BufferedWriter writer = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream("d:/data.txt")));
			
			writer.write("¹þ¹þ123");
			writer.write("ÄãºÃ°¡£¬hello");
			
			writer.flush();
			writer.close();*/
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
