package com.shenjinxiang.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader extends Properties{

	private ConfigReader() {
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("Config.properties");
		try {
			this.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static ConfigReader _instance = new ConfigReader();
	
	public static ConfigReader getConfigReader() {
		return _instance;
	}
	
	public String get(String name) {
		return getProperty(name);
	}
}
