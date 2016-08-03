package com.shenjinxiang.demo;

public class Demo3 {

	public static void main(String[] args) {
		CC c = new CC();
		AA a = new AA();
		BB b = new BB();
		c.test1(a);
	}
	
	
}

class AA {
	
}

class BB extends AA {
	
}

class CC {
	public void test1(AA a) {
		System.out.println("c...a");
	}
	
	public void test1(BB b) {
		System.out.println("c...b");
	}
}

