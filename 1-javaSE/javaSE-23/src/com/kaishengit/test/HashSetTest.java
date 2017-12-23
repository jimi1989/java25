package com.kaishengit.test;

import java.util.HashSet;
import java.util.Set;

import com.kaishengit.entity.Student;

public class HashSetTest {

	public static void main(String[] args) {
		
		Set<Student> stus = new HashSet<>();
		
		Student stu1 = new Student();
		stu1.setAge(23);
		stu1.setName("rose");
	
		Student stu2 = new Student();
		stu2.setAge(23);
		stu2.setName("rose");
		
		stus.add(stu1);
		stus.add(stu2);
		
		System.out.println(stus.size());
		
		
		/*Set<String> sets = new HashSet<>();
		
		sets.add("aa");
		sets.add("bb");
		sets.add("cc");
		sets.add("aa");*/
		
		
//		System.out.println(sets.contains("aaa"));
//		
////		sets.clear();
//		System.out.println(sets.isEmpty());
//		System.out.println(sets.size());
		
		//µü´ú
		/*for(String str : sets) {
			System.out.println(str);
		}*/
		
		// µü´úÆ÷
		/*Iterator<String> it = sets.iterator();

		while(it.hasNext()) {
			System.out.println(it.next());
		}*/
		
		
		
		
		
		
		
		
	}
	
}
