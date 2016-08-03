package com.shenjinxiang.demo;

public class Demo2 {
	public static void main(String[] args) {
		A a1 = new A();
		A a2 = new B();
		B b = new B();
		C c = new C();
		D d = new D();
		System.out.println(a2.show(b));
	}
}

class A {
	public String show(D obj) {
		return ("A and D");
	}
	
	public String show(A obj) {
		return ("A and A");
	}
}

class B extends A{
	public String show(B obj) {
		return ("B and B");
	}
	
	public String show(A obj) {
		return ("B and A");
	}
}

class C extends B{}

class D extends B{}