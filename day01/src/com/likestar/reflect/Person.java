package com.likestar.reflect;

import java.util.UUID;

public class Person {

	private String id;
	private String name;
	private int age;
	private String address;
	private String desc;
	
	public Person() {
		this.id = UUID.randomUUID().toString().replace("-", "");
	}
	
	public Person(String name, int age) {
		this.id = UUID.randomUUID().toString().replace("-", "");
		this.name = name;
		this.age = age;
	}
	
	public Person(String name, int age, String address, String desc) {
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
	
	
}
