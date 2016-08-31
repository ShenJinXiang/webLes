package com.qysoft.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader extends Properties {

	private static ConfigReader _instance = new ConfigReader();
	
	private ConfigReader() {
		getClass().getClassLoader();
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("Config.properties");
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
	
	public static ConfigReader getConfigReader() {
		return _instance;
	}
	
	public String get(String key) {
		return this.getProperty(key);
	}
}
