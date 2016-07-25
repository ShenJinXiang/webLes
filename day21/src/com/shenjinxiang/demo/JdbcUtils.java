package com.shenjinxiang.demo;

import java.lang.reflect.Method;

import com.shenjinxiang.annotation.DbInfo;

public class JdbcUtils {
	
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	
	static {
		try {
			Method method = JdbcUtils.class.getMethod("getConnection", null);
			DbInfo info = method.getAnnotation(DbInfo.class);
			driver = info.driver();
			url = info.url();
			username = info.username();
			password = info.password();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@DbInfo(driver = "com.mysql.jdbc.Driver", password = "jdbc:mysql://localhost:3306/webTest", url = "root", username = "6098")
	public static void getConnection() throws NoSuchMethodException, SecurityException {
		System.out.println("driver -> " + driver);
		System.out.println("url -> " + url);
		System.out.println("username -> " + username);
		System.out.println("password -> " + password);
	}
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		JdbcUtils.getConnection();
	}
}
