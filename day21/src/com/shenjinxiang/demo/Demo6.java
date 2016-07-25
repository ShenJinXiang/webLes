package com.shenjinxiang.demo;

import org.junit.Test;

import com.shenjinxiang.annotation.Gender;
import com.shenjinxiang.annotation.MyAnnotation1;
import com.shenjinxiang.annotation.MyAnnotation2;

public class Demo6 {

//	@MyAnnotation1(gender = Gender.女, ss = { "aa", "bb" })
	public void test1() {
		
	}
	
	@Test
	public void test2(){
		System.out.println(Gender.MALE);
	}
	
	@MyAnnotation1(name = "ZhangSan", age = 18)
	public void test3() {
		Class clazz = Demo6.class;
	}
}
