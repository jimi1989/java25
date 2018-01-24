package com.kaishengit.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.kaishengit.entity.User;

public class GsonTest {

	public static void main(String[] args) {
		
		User user = new User(23,"lebron",32);
		Gson gson = new Gson();
		
		List<String> lists = new ArrayList<>();
		lists.add("david");
		lists.add("tom");
		lists.add("hanks");
		
		Map<String,String> maps = new HashMap<>();
		maps.put("name", "kobe");
		maps.put("age", "38");
		
		User user1 = new User(1, "jack", 23);
		User user2 = new User(2, "tom", 25);
		User user3 = new User(3, "rose", 33);
		User user4 = new User(4, "hank", 53);

		List<User> userList = Arrays.asList(user1, user2, user3, user4);
		
//		String json = gson.toJson(user); // {}
//		String json = gson.toJson(lists); // []
//		String json = gson.toJson(maps); // {}
		String json = gson.toJson(userList);// []
		System.out.println(json);
		
	}

}
