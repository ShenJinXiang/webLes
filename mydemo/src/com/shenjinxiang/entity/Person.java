package com.shenjinxiang.entity;

public class Person {

	private int age;
	private String name;
	
	public Person() {
		
	}

	public Person(String name, int age) {
		this.age = age;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static void main(String[] args) {
		Person p = new Person("刘备", 54);
		System.out.println(p);
	}
	
}
