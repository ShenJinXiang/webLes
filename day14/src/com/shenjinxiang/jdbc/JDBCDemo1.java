package com.shenjinxiang.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class JDBCDemo1 {

	@Test
	public void test1() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/webTest";
		String username = "root";
		String password = "6098";
		
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		
		Connection conn = DriverManager.getConnection(url, username, password);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from user");
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		while(rs.next()) {
			Map<String, Object> map = new HashMap<>();
			map.put("id", rs.getInt("id"));
			map.put("username", rs.getString("username"));
			map.put("brithday", rs.getDate("brithday"));
			map.put("entry_date", rs.getDate("entry_date"));
			map.put("job", rs.getString("job"));
			map.put("salary", rs.getDouble("salary"));
			map.put("resume", rs.getString("resume"));
			list.add(map);
		}
		
		rs.close();
		st.close();
		conn.close();
		
		for(Map<String, Object> map : list) {
			System.out.println(map);
		}
	}
}
