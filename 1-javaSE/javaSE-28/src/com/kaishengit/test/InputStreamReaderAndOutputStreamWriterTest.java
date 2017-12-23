package com.kaishengit.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderAndOutputStreamWriterTest {

	public static void main(String[] args) {

		
		try {
			InputStreamReader reader = new InputStreamReader(
					new FileInputStream("d:/data.txt"));
			
			int len = -1;
			char[] buff = new char[512];
			
			StringBuffer buffer = new StringBuffer();
			while((len = reader.read(buff)) != -1) {
//				String str = new String(buff, 0, len);
				buffer.append(buff, 0, len);
			}
			
			System.out.println(buffer.toString());
			
			reader.close();
			
			
			/*InputStreamReader reader = new InputStreamReader(
					new FileInputStream("d:/data.txt"));
			
			int len = -1;
			StringBuffer buffer = new StringBuffer();
			while((len = reader.read()) != -1) {
				char ch = (char)len;
				buffer.append(ch);
//				System.out.print(ch);
			}
			
			System.out.println(buffer.toString());
			
			reader.close();*/
			
			/*OutputStreamWriter writer = new OutputStreamWriter(
					new FileOutputStream("d:/data.txt"));
			writer.write("hello,writer\n");
			writer.write("haha");
		
			writer.flush();
			writer.close();*/
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
