package com.shenjinxiang.demo;

<<<<<<< HEAD
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Demo2 {

	public static void main(String[] args) {
//		List<String> list = new ArrayList<>();
//		for(int i = 0; i < 100; i++) {
//			String msg = test2(10);
//			list.add(msg);
//		}
//		System.out.println(list);
//		Random rd = new Random();
//		int n = rd.nextInt(list.size());
//		System.out.println(n);
//		System.out.println(list.get(n));
		String msg = "爱芳芳";
		String m1 = Base64En(msg);
		System.out.println(m1);
		System.out.println(Base64De(m1));
	}
	
	private static String Base64En(String data)  {
		try {
			return new BASE64Encoder().encode(data.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private static String Base64De(String data) {
		try {
			return new String(new BASE64Decoder().decodeBuffer(data), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static String test1() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	private static String test2(int num) {
		char[] src = {
			'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
			'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
			'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
		};
		char[] cs = new char[num];
		Random rd = new Random();
		for(int i = 0; i < num; i++){
			cs[i] = src[rd.nextInt(src.length)];
		}
		return new String(cs);
	}
}
=======
public class Demo2 {
	public static void main(String[] args) {
		A a1 = new A();
		A a2 = new B();
		B b = new B();
		C c = new C();
		D d = new D();
		System.out.println(a2.show(b));
		System.out.println(b.show(c));
		System.out.println(b.show(d));
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
>>>>>>> ecf078ba0d7df2a9e6cb614993a871dd7fe98a2a
