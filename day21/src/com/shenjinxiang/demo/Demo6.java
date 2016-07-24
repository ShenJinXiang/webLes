package com.shenjinxiang.demo;

import org.junit.Test;

import com.shenjinxiang.annotation.Gender;
import com.shenjinxiang.annotation.MyAnnotation1;
import com.shenjinxiang.annotation.MyAnnotation2;

public class Demo6 {

	@MyAnnotation1(gender = Gender.女, ss = { "aa", "bb" })
	public void test1() {
		
	}
	
	@Test
	public void test2(){
		System.out.println(Gender.男);
	}
	
	@MyAnnotation2(value = "122")
	public void test3() {
		
	}
}
