package com.kaishengit.test;

import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.kaishengit.entity.Account;
import com.kaishengit.mapper.AccountMapper;

public class QueryTest {

	public static void main(String[] args) {
		
		Reader reader;
		try {
			reader = Resources.getResourceAsReader("mybatis.xml");
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			
			SqlSession session = sessionFactory.openSession(true);
			
			AccountMapper mapper = session.getMapper(AccountMapper.class);
//			Account acc = mapper.findByNameAndPassword("jack", "123123");
//			Map<String,String> params = new HashMap<>();
//			params.put("email", "123@qq.com");
//			params.put("name", "jack");
//			Account acc = mapper.findByNameOrEamil(params);
//			Account acc = mapper.findByNameOrEamil2(params);
//			System.out.println(acc);
			
			Account account = new Account("batch1", "b@qq.com", "123123", 123, true);			
			Account account2 = new Account("batch2", "b2@qq.com", "123123", 1230, true);			
			
			List<Account> lists = Arrays.asList(account, account2);
			mapper.batchInsert(lists);
			System.out.println("success");
			
			session.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
