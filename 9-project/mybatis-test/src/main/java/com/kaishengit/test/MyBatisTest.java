package com.kaishengit.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.kaishengit.entity.User;
import com.kaishengit.mapper.UserMapper;

public class MyBatisTest {

	public static void main(String[] args) {

		try {
			Reader reader = Resources.getResourceAsReader("mybatis.xml");
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			
			SqlSession session = sessionFactory.openSession(true);
//			User user = session.selectOne("com.kaishengit.mapper.UserMapper.findById",10);
			
			/*User user = new User();
			user.setId(15);
			user.setName("mybatis");
			user.setTel("2222");
			user.setAddress("河南焦作");*/
			
//			session.insert("com.kaishengit.mapper.UserMapper.save",user);
//			session.update("com.kaishengit.mapper.UserMapper.update",user);
//			session.delete("com.kaishengit.mapper.UserMapper.delete",12);
			
			/*List<User> userList = session.selectList("com.kaishengit.mapper.UserMapper.findAll");
			
			for(User user : userList) {
				System.out.println(user);
			}*/
			
//			
			UserMapper mapper = session.getMapper(UserMapper.class);
			User user = mapper.findById(10);
			System.out.println(user);
//			session.commit();
			session.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
