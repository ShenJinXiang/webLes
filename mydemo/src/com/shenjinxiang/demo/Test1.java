package com.shenjinxiang.demo;

import com.shenjinxiang.entity.Person;

public class Test1 {

	public static void main(String[] args) {
		Person p = new Person();
		p.setAge(12);
		p.setName("张三");
		System.out.println("name : " + p.getName());
		System.out.println("age : " + p.getAge());
	}
}
