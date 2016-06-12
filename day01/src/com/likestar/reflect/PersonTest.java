package com.likestar.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

public class PersonTest {

	@Test
	public void test1() throws ClassNotFoundException {
		Class clazz1 = Class.forName("com.likestar.reflect.Person");
		System.out.println("name : " + clazz1.getName());
		System.out.println("type name : " + clazz1.getTypeName());
		System.out.println("simple name : " + clazz1.getSimpleName());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void test2() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class clazz = Class.forName("com.likestar.reflect.Person");
		Constructor constructor = clazz.getConstructor(null);
		Object p1 = constructor.newInstance(null);
		System.out.println(p1);
	}
}
