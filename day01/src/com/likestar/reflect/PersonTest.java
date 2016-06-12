package com.likestar.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class PersonTest {

	@Test
	public void test1() throws ClassNotFoundException {
		Class clazz1 = Class.forName("com.likestar.reflect.Person");
		System.out.println("name : " + clazz1.getName());
		System.out.println("type name : " + clazz1.getTypeName());
		System.out.println("simple name : " + clazz1.getSimpleName());
	}
	
	
	/**
	 * 反射构造函数 Person()
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void test2() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class clazz = Class.forName("com.likestar.reflect.Person");
		Constructor constructor = clazz.getConstructor(null);
		Object p1 = constructor.newInstance(null);
		System.out.println(p1);
	}
	
	/**
	 * 反射 Person(String name, int age)
	 * @throws Exception
	 */
	@Test
	public void Test3() throws Exception {
		Class clazz = Class.forName("com.likestar.reflect.Person");
		Constructor constructor = clazz.getConstructor(String.class, int.class);
		Object p1 = constructor.newInstance("张三", 18);
		System.out.println(p1);
	}
	
	/**
	 * 反射 Person(String name, int age, String address, String desc)
	 * @throws Exception
	 */
	@Test
	public void Test4() throws Exception {
		Class clazz = Class.forName("com.likestar.reflect.Person");
		Constructor constructor = clazz.getConstructor(String.class, int.class, String.class, String.class);
		Object p1 = constructor.newInstance("张三", 18, "北京", "一个好人！");
		System.out.println(p1);
	}
	
	/**
	 * 反射main方法
	 * @throws Exception
	 */
	@Test
	public void Test5() throws Exception {
		Class clazz = Class.forName("com.likestar.reflect.Person");
		Method mainMethod = clazz.getMethod("main", String[].class);
		mainMethod.invoke(null, (Object)(new String[]{"aa", "bb"}));
	}
	
	/**
	 * 反射sayHello方法
	 * @throws Exception
	 */
	@Test
	public void test6() throws Exception {
		Class clazz = Class.forName("com.likestar.reflect.Person");
		Method method = clazz.getMethod("sayHello");
		Constructor constructor = clazz.getConstructor(String.class, int.class);
		Object p = constructor.newInstance("张三", 18);
		method.invoke(p);
	}
	
	/**
	 * 获取Person类中的方法
	 * @throws Exception
	 */
	@Test
	public void test7() throws Exception {
		Class clazz = Class.forName("com.likestar.reflect.Person");
//		Method[] methods = clazz.getMethods();
		Method[] methods = clazz.getDeclaredMethods();
		for(Method m : methods) {
			System.out.println(m.getName());
		}
	}
}
