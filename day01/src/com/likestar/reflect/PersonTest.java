package com.likestar.reflect;

import org.junit.Test;

public class PersonTest {

	@Test
	public void test1() throws ClassNotFoundException {
		Class clazz1 = Class.forName("com.likestar.reflect.Person");
		System.out.println("name : " + clazz1.getName());
		System.out.println("type name : " + clazz1.getTypeName());
		System.out.println("simple name : " + clazz1.getSimpleName());
	}
}
