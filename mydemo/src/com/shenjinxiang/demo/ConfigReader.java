package com.shenjinxiang.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader extends Properties {

	private ConfigReader() {
		InputStream in = ClassLoader.getSystemResourceAsStream("Config.properties");
		try {
			this.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private static ConfigReader _instance = new ConfigReader();
	
	public static ConfigReader getConfigReader() {
		return _instance;
	}
	
	public String get(String key) {
		return this.getProperty(key);
	}
}
