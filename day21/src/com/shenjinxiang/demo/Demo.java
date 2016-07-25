package com.shenjinxiang.demo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.junit.Test;

import com.shenjinxiang.annotation.Gender;
import com.shenjinxiang.annotation.TestAnnotation;
import com.shenjinxiang.config.Config;

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
	
	@Test
	public void test1() throws NoSuchMethodException, SecurityException {
		Method method = Demo.class.getMethod("test", null);
		System.out.println(method.isAnnotationPresent(TestAnnotation.class));
		Annotation[] as = method.getAnnotations();
		for(Annotation anno : as) {
			if(anno instanceof TestAnnotation) {
				String name = ((TestAnnotation) anno).name();
				int age = ((TestAnnotation) anno).age();
				Gender gender = ((TestAnnotation) anno).gender();
				System.out.println("name -> " + name);
				System.out.println("age -> " + age);
				System.out.println("gender -> " + gender);
			}
		}
	}
	
	@Test
	public void test2() {
		System.out.println(Config.NAME);
		System.out.println(Config.AGE);
		System.out.println(Config.WORK);
	}
}
