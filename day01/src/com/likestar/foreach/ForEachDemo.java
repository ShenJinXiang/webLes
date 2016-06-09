package com.likestar.foreach;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

public class ForEachDemo {

	/**
	 * for each 循环遍历 数组
	 */
	@Test
	public void for_arr() {
		int [] arr = {1, 2, 3, 4, 5};
		for(int num : arr){
			System.out.print(num + "\t");
		}
		System.out.println();
	}
	
	
	/**
	 * for each 循环遍历list
	 */
	@Test
	public void for_list() {
		List list = new ArrayList();
		list.add(1);
		list.add(3);
		list.add(5);
		list.add(7);
		list.add(9);
		
		for(Object n : list) {
			int num = (int)n;
			System.out.print(num + "\t");
		}
		System.out.println();
	}
	
	/**
	 * for each 循环遍历map
	 */
	@Test
	public void for_map1() {
//		Map<String, String> map = new HashMap<String, String>();
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("name", "张三");
		map.put("sex", "男");
		map.put("address", "BeiJing");
		Set<String> keys = map.keySet();
		for(String key: keys) {
			System.out.println(key + " = " + map.get(key));
		}
	}
	
	
	/**
	 * for each 循环遍历map
	 */
	@Test
	public void for_map2() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "张三");
		map.put("sex", "男");
		map.put("address", "BeiJing");
		Set<Entry<String, String>> entrys = map.entrySet();
		for(Entry entry: entrys) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
	}
}
