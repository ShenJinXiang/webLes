package com.shenjinxiang.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UploadServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("****************");
		InputStream in = req.getInputStream();
		int len = 0;
		byte buffer[] =  new byte[1024];
		while((len = in.read(buffer)) > 0) {
			System.out.println(new String(buffer, 0, len));
		}
	}

}
