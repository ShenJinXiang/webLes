package com.shenjinxiang.demo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.junit.Test;

import com.shenjinxiang.annotation.Gender;
import com.shenjinxiang.annotation.TestAnnotation;
import com.shenjinxiang.config.Config;
import com.shenjinxiang.entity.Student;

public class Demo {

	@Test
	@TestAnnotation(age = 18, name = "张三", gender = Gender.MALE)
	public void test() throws NoSuchMethodException, SecurityException {
		Method method = Demo.class.getMethod("test", null);
		TestAnnotation ta = method.getAnnotation(TestAnnotation.class);
		Class ac = ta.annotationType();
		System.out.println(ac.getName());
		System.out.println(ta);
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
	
	@Test
	public void test3() {
		Class personClass = com.shenjinxiang.entity.Person.class;
		Annotation[] pas = personClass.getAnnotations();
		System.out.println("Person 类的注解有：");
		for(Annotation anno : pas) {
			System.out.println(anno.annotationType().getName());
		}
		Class studentClass = Student.class;
		Annotation[] sas = studentClass.getAnnotations();
		System.out.println("Student 类的注解有：");
		for(Annotation anno : sas) {
			System.out.println(anno.annotationType().getName());
		}
	}
}
