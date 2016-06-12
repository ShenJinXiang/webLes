package com.likestar.reflect;

import java.util.UUID;

public class Person {

	private String id;
	private String name;
	private int age;
	private String address;
	private String desc;
	
	public Person() {
		System.out.println("Person()");
		this.id = UUID.randomUUID().toString().replace("-", "");
	}
	
	public Person(String name, int age) {
		System.out.println("Person(String, int)");
		this.id = UUID.randomUUID().toString().replace("-", "");
		this.name = name;
		this.age = age;
	}
	
	public Person(String name, int age, String address, String desc) {
		System.out.println("Person(String, int, String, String)");
		this.id = UUID.randomUUID().toString().replace("-", "");
		this.name = name;
		this.age = age;
		this.address = address;
		this.desc = desc;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + ", desc=" + desc + "]";
	}
	
	public void sayHello() {
		System.out.println("Hello, my name is " + this.name);
	}
	
	public static void main(String[] args) {
		System.out.println("Hello world!");
		for(String arg : args) {
			System.out.print(arg + "\t");
		}
		System.out.println();
	}
}
