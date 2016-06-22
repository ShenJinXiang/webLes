package com.shenjinxiang.servlet.response;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RefreshServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		test1(req, resp);
	}

	private void test1(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY年MM月dd日 HH:mm:ss");
		String str = "<h2>" + sdf.format(new Date()) + "</h2>";
		resp.setHeader("content-type", "text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setHeader("refresh", "1");
		System.out.println(str);
		resp.getWriter().write(str);
	}

	
}
