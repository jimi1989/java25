package com.kaishengit.service;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.kaishengit.entity.Account;

public class GuavaTestCase {

	@Test
	public void ListFilterTest(){
		Account acc = new Account();
		acc.setUsername("jack");

		Account acc1 = new Account();
		acc1.setUsername("rose");

		Account acc2 = new Account();
		acc2.setUsername("rose2");

		List<Account> accList = Lists.newArrayList(acc, acc1, acc2);
		// 过滤所有username以ro开头的acc封装成List集合
		List<Account> subList = Lists.newArrayList(Collections2.filter(accList, new Predicate<Account>() {
			@Override
			public boolean apply(Account acc) {
				return acc.getUsername().startsWith("ro");
			}
		}));
		
		for(Account account : subList) {
			System.out.println(account.getUsername());
		}
	}
	
	@Test
	public void ListTransformTest(){
		Account acc = new Account();
		acc.setUsername("jack");

		Account acc1 = new Account();
		acc1.setUsername("rose");

		Account acc2 = new Account();
		acc2.setUsername("rose2");

		List<Account> accList = Lists.newArrayList(acc, acc1, acc2);
		
		// 封装username的list集合
		List<String> nameList = Lists.newArrayList(Collections2.transform(accList, new Function<Account, String>() {
			@Override
			public String apply(Account acc) {
				return acc.getUsername();
			}
		}));
		
		for(String name : nameList) {
			System.out.println(name);
		}
		
		/*List<String> nameList = Lists.newArrayList();
		for(Account account : accList) {
			nameList.add(account.getUsername());
		}*/
		
	}
	
	
	@Test
	public void collectionTest() {
		//List<String> strList = new ArrayList<>(); 1.7+
//		List<String> strList = new ArrayList<String>();
		List<String> strList = Lists.newArrayList("aa","bb","cc");
//		strList.add("aa");
//		strList.add("bb");
//		strList.add("cc");
		
//		Set<String> sets = Sets.newHashSet("aa","bb");
		Map<String,String> maps = Maps.newHashMap();
		
		for(String str : strList) {
			System.out.println(str);
		}
		
	}
	
	
	
	
	
	
	
}
