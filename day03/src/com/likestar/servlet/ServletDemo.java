package com.likestar.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

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
	
	/**
	 * 简单测试
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void test1(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String str = "abcdefgh";
		resp.getWriter().write(str);
	}
	
	/**
	 * 带标签的测试
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	private void test2(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String str = "<h1>shenjinxiang</h1>";
		resp.getWriter().write(str);
	}
	
	/**
	 * gzip压缩测试
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	private void test3(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String str = "<h1>ShenJinXiang</h1><p>测试测试  abcdefghijklmnopqrstuvwxyz<br/>abcdefghijklmnopqrstuvwxyz<br/>abcdefghijklmnopqrstuvwxyz<br/>abcdefghijklmnopqrstuvwxyz<br/>abcdefghijklmnopqrstuvwxyz<br/>abcdefghijklmnopqrstuvwxyz<br/>abcdefghijklmnopqrstuvwxyz<br/>abcdefghijklmnopqrstuvwxyz<br/>abcdefghijklmnopqrstuvwxyz<br/>abcdefghijklmnopqrstuvwxyz<br/>abcdefghijklmnopqrstuvwxyz<br/>abcdefghijklmnopqrstuvwxyz<br/>abcdefghijklmnopqrstuvwxyz<br/>abcdefghijklmnopqrstuvwxyz<br/>abcdefghijklmnopqrstuvwxyz<br/>abcdefghijklmnopqrstuvwxyz<br/>abcdefghijklmnopqrstuvwxyz<br/>abcdefghijklmnopqrstuvwxyz<br/>abcdefghijklmnopqrstuvwxyz<br/>abcdefghijklmnopqrstuvwxyz<br/>abcdefghijklmnopqrstuvwxyz<br/>abcdefghijklmnopqrstuvwxyz<br/>abcdefghijklmnopqrstuvwxyz<br/>abcdefghijklmnopqrstuvwxyz<br/>abcdefghijklmnopqrstuvwxyz<br/>abcdefghijklmnopqrstuvwxyz<br/>abcdefghijklmnopqrstuvwxyz<br/>abcdefghijklmnopqrstuvwxyz<br/>abcdefghijklmnopqrstuvwxyz<br/>abcdefghijklmnopqrstuvwxyz<br/>abcdefghijklmnopqrstuvwxyz<br/>abcdefghijklmnopqrstuvwxyz<br/>abcdefghijklmnopqrstuvwxyz<br/>abcdefghijklmnopqrstuvwxyz<br/>abcdefghijklmnopqrstuvwxyz<br/>abcdefghijklmnopqrstuvwxyz<br/>abcdefghijklmnopqrstuvwxyz<br/>abcdefghijklmnopqrstuvwxyz<br/>abcdefghijklmnopqrstuvwxyz<br/>abcdefghijklmnopqrstuvwxyz<br/>abcdefghijklmnopqrstuvwxyz<br/>abcdefghijklmnopqrstuvwxyz<br/>abcdefghijklmnopqrstuvwxyz<br/>abcdefghijklmnopqrstuvwxyz<br/>abcdefghijklmnopqrstuvwxyz<br/></p>";
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		GZIPOutputStream gout = new GZIPOutputStream(bout);
		gout.write(str.getBytes());
		gout.close();
		byte gzip[] = bout.toByteArray();
		System.out.println("压缩前：" + str.getBytes().length);
		System.out.println("压缩后：" + gzip.length);
		resp.setHeader("Content-Encoding", "gzip");
		resp.setHeader("Content-Length", gzip.length + "");
		resp.getOutputStream().write(gzip);
	}
	
	private int count = 0;
	
	/**
	 * 每隔3秒刷新一次
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	private void test4(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String str = "<h1>shenjinxiang" + count++ + "</h1>";
		resp.setHeader("Refresh", "3");
		resp.setHeader("Content-Type", "text/html");
		System.out.println(str);
		resp.getOutputStream().write(str.getBytes());
	}
}
