package com.shenjinxiang.run;

public class Demo3 {

	public static void main(String[] args) {
		ThreadPool.getThread().execute(new Demo1("0"));
		ThreadPool.getThread().execute(new Demo1("1"));
		ThreadPool.getThread().execute(new Demo1("2"));
		ThreadPool.getThread().execute(new Demo1("3"));
		ThreadPool.getThread().execute(new Demo1("4"));
		ThreadPool.getThread().execute(new Demo1("5"));
		ThreadPool.getThread().execute(new Demo1("6"));
		ThreadPool.getThread().execute(new Demo1("7"));
		ThreadPool.getThread().execute(new Demo1("8"));
		ThreadPool.getThread().execute(new Demo1("9"));
		ThreadPool.getThread().execute(new Demo1("10"));
		ThreadPool.getThread().execute(new Demo1("11"));
		ThreadPool.getThread().execute(new Demo1("12"));
		ThreadPool.getThread().execute(new Demo1("13"));
		ThreadPool.getThread().execute(new Demo1("14"));
		ThreadPool.getThread().execute(new Demo1("15"));
		ThreadPool.getThread().execute(new Demo1("16"));
		ThreadPool.getThread().shutdown();
	}
	
	// 0 5 4 6 8 3 9 10 7 16 2 15 14 12 13 1 11
}
