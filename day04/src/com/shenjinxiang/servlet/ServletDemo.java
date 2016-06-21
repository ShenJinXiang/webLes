package com.shenjinxiang.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		test4(req, resp);
	}
	
	public void test1(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String str = "<h1>I LOVE fangfang!!!</h1>";
		resp.setHeader("Content-Type", "text/html");
		resp.getWriter().write(str);
	}
	
	public void test2(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("Hello world!");
		String str = "Hello World";
		resp.getOutputStream().write(str.getBytes());
	}
	
	/**
	 * 获取web.xml中context-param配置
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	public void test3(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Enumeration names = this.getServletContext().getInitParameterNames();
		while(names.hasMoreElements()){
			String name = (String) names.nextElement();
			String value = this.getServletContext().getInitParameter(name);
			System.out.println(name + " --> " + value);
		}
		resp.getOutputStream().write("hello world!".getBytes());
	}
	
	/**
	 * 获取配置文件内容
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	public void test4(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		InputStream in = this.getServletContext().getResourceAsStream("/WEB-INF/classes/config.properties");
		Properties prop = new Properties();
		prop.load(in);
		String contextName = prop.getProperty("contextName");
		String url = prop.getProperty("url");
		System.out.println("contextName -> " + contextName);
		System.out.println("url --> " + url);
		resp.getOutputStream().write("hello world!!".getBytes());
	}
}
