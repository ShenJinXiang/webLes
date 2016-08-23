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
			System.out.println("名称：" + this.name + "  循环次数： " + i);
		} 
		try {
			Thread.sleep(1000 * 1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.name + " 结束了");
	}

}
