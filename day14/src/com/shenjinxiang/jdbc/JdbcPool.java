package com.shenjinxiang.jdbc;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

public class JdbcPool implements DataSource {
	
	private static LinkedList<Connection> list = new LinkedList<>();
	private static Properties prop = new Properties();
	
	static {
		try {
			prop.load(JdbcPool.class.getClassLoader().getResourceAsStream("db.properties"));
			
			Class.forName(prop.getProperty("driver"));
			for(int i = 0; i < 10; i++) {
				Connection conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
				list.add(conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	@Override
	public Connection getConnection() throws SQLException {
		if(list.size() <= 0) {
			throw new RuntimeException("数据库忙，请稍后！");
		}
		return list.removeFirst();
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}


}
