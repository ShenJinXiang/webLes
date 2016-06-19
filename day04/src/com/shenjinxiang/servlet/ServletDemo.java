package com.shenjinxiang.servlet;

import java.io.IOException;

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
		test2(req, resp);
	}
	
	public void test1(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String str = "<h1>I LOVE fangfang!!!</h1>";
		resp.setHeader("Content-Type", "text/html");
		resp.getWriter().write(str);
	}
	
	public void test2(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String str = "Hello World";
		resp.getOutputStream().write(str.getBytes());
	}

}
