package com.shenjinxiang.config;

public class Config {

	public static final String NAME;
	public static final String AGE;
	public static final String WORK;
	
	static {
		NAME = get("name");
		AGE = get("age");
		WORK = get("work");
	}
	
	public static String get(String name) {
		return ConfigReader.getConfigReader().get(name);
	}
}
