package com.shenjinxiang.run;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

	private static ExecutorService fixedThreadPool;
	
	private ThreadPool() {}
	
	static {
		fixedThreadPool = Executors.newFixedThreadPool(10);
	}
	
	public static ExecutorService getThread() {
		return fixedThreadPool;
	}
	
	public void down() {
		fixedThreadPool.shutdown();
	}
	
	
}
