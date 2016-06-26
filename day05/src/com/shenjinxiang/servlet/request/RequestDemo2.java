package com.shenjinxiang.servlet.request;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestDemo2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doForGet(req, resp);
	}

	private void doForGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String username = req.getParameter("username");
		String val = new String(username.getBytes("iso8859-1"), "utf-8");
		System.out.println("username : " + username);
		System.out.println("val : " + val);
		resp.getWriter().write("<h1>hello world!</h1>");
	}

	/**
	 * post 乱码处理
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	private void doForPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("username");
		System.out.println("username : " + username);
		resp.getWriter().write("<h1>hello world!</h1>");
		
	}

}
