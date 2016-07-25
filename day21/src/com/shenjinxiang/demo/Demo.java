package com.shenjinxiang.demo;

import java.lang.reflect.Method;

import org.junit.Test;

import com.shenjinxiang.annotation.Gender;
import com.shenjinxiang.annotation.TestAnnotation;

public class Demo {

	@Test
	@TestAnnotation(age = 18, name = "张三", gender = Gender.MALE)
	public void test() throws NoSuchMethodException, SecurityException {
		Method method = Demo.class.getMethod("test", null);
		TestAnnotation ta = method.getAnnotation(TestAnnotation.class);
		String name  = ta.name();
		int age = ta.age();
		Gender gender = ta.gender();
		System.out.println("name -> " + name);
		System.out.println("age -> " + age);
		System.out.println("gender -> " + gender);
	}
}
