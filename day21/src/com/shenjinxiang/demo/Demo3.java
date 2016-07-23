package com.shenjinxiang.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Demo3 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
//		Iterator<String> it = list.iterator();
		ListIterator<String> it = list.listIterator();
		while(it.hasNext()) {
			System.out.print(it.next() + "   ");
			it.add("g");
		}
		
		System.out.println();
		for(String str : list) {
			System.out.print(str + "  ");
		}
	}
}
