package com.kaishengit.test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapTest {

	public static void main(String[] args) {
		
		Map<String,String> maps = new Hashtable<>();
		maps.put("k1", "v1");
		maps.put("k2", "v2");
		maps.put("k3", "v3");
		
		Set<Entry<String,String>> entrys = maps.entrySet();
		
		for(Entry<String,String> entry : entrys) {
			
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + "-->" + value);
		}
		
		
		//迭代
		/*Set<String> keys = maps.keySet();// 获得map集合的key的Set集合
		for(String key : keys) {//迭代key的Set集合
			String value = maps.get(key); // 根据每次迭代的key获得映射的value
			System.out.println(key + "-->" + value);
		}*/
		
		
		
		
		/*maps.remove("k1");
		System.out.println(maps.containsKey("k2"));
		System.out.println(maps.containsValue("v3"));
		
		System.out.println(maps.size());
		
		//get
		System.out.println(maps.get("k1"));*/
		
		
		
	}

}
