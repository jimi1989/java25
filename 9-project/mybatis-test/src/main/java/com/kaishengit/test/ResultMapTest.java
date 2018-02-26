package com.kaishengit.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.kaishengit.entity.Student;
import com.kaishengit.mapper.StudentMapper;

public class ResultMapTest {

	public static void main(String[] args) {
		
		Reader reader;
		try {
			reader = Resources.getResourceAsReader("mybatis.xml");
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			
			SqlSession session = sessionFactory.openSession(true);
			
			/*SchoolMapper mapper = session.getMapper(SchoolMapper.class);
			School school = mapper.findById(2);
			System.out.println(school);*/
			
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			Student stu = mapper.findById(2);
			System.out.println(stu);
			
			session.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
