package com.kaishengit.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputOutputStreamTest {

	public static void main(String[] args) {

		try {
			
			DataInputStream dataInputStream = new DataInputStream(new FileInputStream("d:/img/data.dat"));
			
			int intres = dataInputStream.readInt();
			double doubleres = dataInputStream.readDouble();
			String strres = dataInputStream.readUTF();
			
			System.out.println(intres);
			System.out.println(doubleres);
			System.out.println(strres);
			
			dataInputStream.close();
			
			/*DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("d:/img/data.dat"));
			dataOutputStream.writeInt(123);
			dataOutputStream.writeDouble(456.789);
			dataOutputStream.writeUTF("java IOÁ÷Õæ·Ñ¾¢");
			
			dataOutputStream.flush();
			dataOutputStream.close();*/
			
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		
		
	}

}
