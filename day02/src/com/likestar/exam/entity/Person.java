package com.likestar.exam.entity;

import java.io.Serializable;

public class Person implements Serializable{

	private String name;
	private int age;
	private String address;
	private String desc;

	public Person() {
		
	}
	
	public Person(String name, int age, String address, String desc) {
		this.name = name;
		this.age = age;
		this.address = address;
		this.desc = desc;
	}
	

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", address=" + address + ", desc=" + desc + "]";
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

	
	
}
