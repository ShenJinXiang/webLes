package com.shenjinxiang.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class JDBCDemo3 {

	@Test
	public void insert() throws SQLException {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtils.getConnection();
			st = conn.createStatement();
			String sql = "insert into user (`id`, `username`, `brithday`, `entry_date`, `job`, `salary`, `resume`)"
					+ "values (3, 'LikeStar', '1986-10-12', '2005-09-18', 'python', 2222.22, 'hehe')";
			int num = st.executeUpdate(sql);
			if(num > 0) {
				System.out.println("ok");
			}
		} finally {
			JdbcUtils.replease(conn, st, rs);
		}
	}
	
	@Test
	public void update() throws SQLException {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtils.getConnection();
			st = conn.createStatement();
			String sql = "update user set username = 'zss' where id = 1";
			int num = st.executeUpdate(sql);
			if(num > 0) {
				System.out.println("ok");
			}
		} finally {
			JdbcUtils.replease(conn, st, rs);
		}
	}
	

	@Test
	public void delete() throws SQLException {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtils.getConnection();
			st = conn.createStatement();
			String sql = "delete from user where id = 1";
			int num = st.executeUpdate(sql);
			if(num > 0) {
				System.out.println("ok");
			}
		} finally {
			JdbcUtils.replease(conn, st, rs);
		}
	}
	
	@Test
	public void getAll() throws SQLException {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtils.getConnection();
			st = conn.createStatement();
			String sql = "select * from user";
			rs = st.executeQuery(sql);
			List<User> list = new ArrayList<User>();
			while(rs.next()) {
				User user = new User();
				user.setBrithday(rs.getDate("brithday"));
				user.setEntry_date(rs.getDate("entry_date"));
				user.setId(rs.getInt("id"));
				user.setImage(rs.getString("image"));
				user.setJob(rs.getString("job"));
//				user.setPassword(rs.getString("password"));
				user.setResume(rs.getString("resume"));
				user.setSalary(rs.getDouble("salary"));
				user.setUsername(rs.getString("username"));
				list.add(user);
			}
			for(User u : list) {
				System.out.println(u);
			}
		} finally {
			JdbcUtils.replease(conn, st, rs);
		}
	}
}
