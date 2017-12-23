package com.kaishengit.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedFileInputOutputStreamTest2 {

	public static void main(String[] args) {
		
		try {
			//创建字节输入输出流的实例
//			FileInputStream inputStream = new FileInputStream("d:/img/1.jpg");
			FileOutputStream outputStream = new FileOutputStream("d:/img/2.jpg");
			
//			BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
			BufferedInputStream bufferedInputStream = new BufferedInputStream(
					new FileInputStream("d:/img/a.jpg"));
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
			
			int len = -1;
			byte[] buffer = new byte[512];
			while((len = bufferedInputStream.read(buffer)) != -1) {
				bufferedOutputStream.write(buffer,0,len);
			}
			
			// 关闭输入输出流
			bufferedOutputStream.flush();
			bufferedOutputStream.close();
			
			bufferedInputStream.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
