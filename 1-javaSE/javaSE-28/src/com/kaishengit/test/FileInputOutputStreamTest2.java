package com.kaishengit.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputStreamTest2 {

	public static void main(String[] args) {
		
		try {
			//创建字节输入输出流的实例
			FileInputStream inputStream = new FileInputStream("d:/img/1.jpg");
			FileOutputStream outputStream = new FileOutputStream("d:/img/2.jpg");
			
			int len = -1;
			byte[] buffer = new byte[1024];
			// 每次从FileInputStream拷贝一个字节到FileOutputStream
			while((len = inputStream.read(buffer)) != -1 ) {
				outputStream.write(buffer,0,len);
			}
			
			// 关闭输入输出流
			
			outputStream.flush();
			outputStream.close();
			
			inputStream.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
