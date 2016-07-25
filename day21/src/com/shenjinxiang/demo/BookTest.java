package com.shenjinxiang.demo;

import java.lang.reflect.Field;

import org.junit.Test;

import com.shenjinxiang.entity.Book;

public class BookTest {

	@Test
	public void test1() {
		Class clazz = Book.class;
//		Field[] fs = clazz.getFields();
//		System.out.println(fs.length );
		Field[] fs = clazz.getDeclaredFields();
		for(Field f : fs) {
			System.out.println(f.getName());
		}
		
	}
	
	
}
