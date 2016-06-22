package com.shenjinxiang.servlet.response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseDemo extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		test3(req, resp);
	}

	/**
	 * 可以打印结果但是又中文乱码
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	private void test1(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String str = "<h1>ShenJinXiang!</h1><p>申锦祥！</p>";
		resp.setHeader("Content-Type", "text/html");
		resp.getOutputStream().write(str.getBytes());
	}

	/**
	 * 解决中文乱码 方法1
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	private void test2(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String str = "<h1>ShenJinXiang!</h1><p>申锦祥！</p>";
		resp.setHeader("Content-Type", "text/html;charset=utf-8");
		resp.getOutputStream().write(str.getBytes());
	}
	
	/**
	 * 方法2 用meta标签模拟 响应头信息
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	private void test3(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String meta = "<meta charset='utf-8'>";
		String str = "<h1>ShenJinXiang!</h1><p>申锦祥！</p>";
		resp.getOutputStream().write((meta + str).getBytes("utf-8"));
	}

}
