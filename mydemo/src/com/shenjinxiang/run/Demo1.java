package com.shenjinxiang.run;

public class Demo1 implements Runnable {
	
	private String name;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Demo1(){
		this.name = "demo1";
	}
	
	public Demo1(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for(int i = 0; i < 100; i++){
			System.out.println(this.name + " " + i);
		} 
		System.out.println(this.name + " 结束了");
	}

}
