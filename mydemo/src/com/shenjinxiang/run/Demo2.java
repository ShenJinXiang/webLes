package com.shenjinxiang.run;

public class Demo2 {

	public static void main(String[] args) {
		Demo1 demo1 = new Demo1();
		Thread t = new Thread(demo1);
		t.start();
		for(int i = 0; i < 100; i++) {
			System.out.println("main " + i);
		}
	}
}
