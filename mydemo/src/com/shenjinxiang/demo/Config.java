package com.shenjinxiang.demo;

public class Config {

	public static final String NAME;
	
	static {
		NAME = get("name");
	}

	private static String get(String key) {
		return ConfigReader.getConfigReader().get(key);
	}
	
	
}
