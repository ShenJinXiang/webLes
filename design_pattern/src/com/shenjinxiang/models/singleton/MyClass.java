package com.shenjinxiang.models.singleton;

public class MyClass {

//	private static MyClass instance = new MyClass();
//	
//	private MyClass() {}
//	
//	public static MyClass getInstance() {
//		return instance;
//	}
	
		
//	private static MyClass instance;
//
//	private MyClass() {}
//
//	public static MyClass getInstance() {
//		if(instance == null) {
//			instance = new MyClass();
//		}
//		return instance;
//	}
	
	private volatile static MyClass instance;

	private MyClass() {}
	
	public static MyClass getInstance() {
		if(instance == null) {
			synchronized (MyClass.class) {
				if(instance == null) {
					instance = new MyClass();
				}
			}
		}
		return instance;
	}
	
	public static void main(String[] args) {
		MyClass m1 = MyClass.getInstance();
		MyClass m2 = MyClass.getInstance();
		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m1 == m2);
	}
	
}
