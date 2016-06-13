package com.likestar.neichun;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class NeiChunTest {

	@Test
	public void test1() {
//		byte[] b = new byte[1024 * 1024 * 126];
//		System.out.println("ok~~");
//		Map<String, Object> map = new HashMap<>();
//		map.values();
	}
	
	@Test
	public void test2() {
		Set<String> set = new HashSet<String>();
		set.add("aaa");
		set.add("222");
		set.add("323");
		set.add("bcd");
		System.out.println(set);
	}
}
