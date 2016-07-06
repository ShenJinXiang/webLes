package com.shenjinxiang.models.singleton;

public class MyClass {

	private static MyClass instance = new MyClass();
	
	private MyClass() {}
	
	public static MyClass getInstance() {
		return instance;
	}
	
	public static void main(String[] args) {
		MyClass m1 = MyClass.getInstance();
		MyClass m2 = MyClass.getInstance();
		System.out.println(m1 == m2);
	}
}
