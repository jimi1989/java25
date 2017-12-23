package com.kaishengit.test;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class PrintStreamTest {

	public static void main(String[] args) {
		
		try {
			PrintStream stream = new PrintStream("d:/data.txt");
			stream.print("hello,print");
			stream.println("hello,println");
			stream.print("hello,print");
		
			stream.flush();
			stream.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
