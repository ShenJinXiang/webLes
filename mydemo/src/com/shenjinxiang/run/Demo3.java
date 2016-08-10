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
		ThreadPool.getThread().execute(new Demo1("a"));
		ThreadPool.getThread().execute(new Demo1("b"));
		ThreadPool.getThread().execute(new Demo1("c"));
		ThreadPool.getThread().execute(new Demo1("d"));
		ThreadPool.getThread().execute(new Demo1("e"));
		ThreadPool.getThread().execute(new Demo1("f"));
		ThreadPool.getThread().execute(new Demo1("g"));
		ThreadPool.getThread().execute(new Demo1("h"));
		ThreadPool.getThread().execute(new Demo1("i"));
		ThreadPool.getThread().execute(new Demo1("j"));
		ThreadPool.getThread().execute(new Demo1("k"));
		ThreadPool.getThread().execute(new Demo1("l"));
		ThreadPool.getThread().execute(new Demo1("m"));
		ThreadPool.getThread().execute(new Demo1("n"));
		ThreadPool.getThread().execute(new Demo1("o"));
		ThreadPool.getThread().execute(new Demo1("p"));
		ThreadPool.getThread().execute(new Demo1("q"));
		ThreadPool.getThread().execute(new Demo1("r"));
		ThreadPool.getThread().execute(new Demo1("s"));
		ThreadPool.getThread().execute(new Demo1("t"));
		ThreadPool.getThread().execute(new Demo1("u"));
		ThreadPool.getThread().execute(new Demo1("v"));
		ThreadPool.getThread().execute(new Demo1("w"));
		ThreadPool.getThread().execute(new Demo1("x"));
		ThreadPool.getThread().execute(new Demo1("y"));
		ThreadPool.getThread().execute(new Demo1("z"));
	}
	
	// 0 5 4 6 8 3 9 10 7 16 2 15 14 12 13 1 11
}
