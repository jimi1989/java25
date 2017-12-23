package com.kaishengit.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.kaishengit.entity.Address;
import com.kaishengit.entity.Student;

public class ObjectInputOutputStreamTest {

	public static void main(String[] args) {
		try{
			
			/*ObjectInputStream objectInputStream = new ObjectInputStream(
					new FileInputStream("d:/stu.dat"));
			
			Student stu = (Student)objectInputStream.readObject();
			
			System.out.println(stu.getAge());
			System.out.println(stu.getName());
			
			objectInputStream.close();*/
			
			
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(
					new FileOutputStream("d:/stu.dat"));
			
			Student stu = new Student();
			stu.setAge(12);
			stu.setName("jack");
			
			Address add = new Address();
			add.setCity("jiaozuo");
			add.setSchool("henanligong");
			
			stu.setAddress(add);
			
			
			objectOutputStream.writeObject(stu);
			
			objectOutputStream.flush();
			objectOutputStream.close();
			
		} catch (IOException e){
			e.printStackTrace();
		} /*catch (ClassNotFoundException e) {
			e.printStackTrace();
		}*/
	}
	
}
