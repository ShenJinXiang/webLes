package com.shenjinxiang.servlet.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestDemo1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("req.getMethod() : " + req.getMethod());
		System.out.println("req.getLocalAddr() : " + req.getLocalAddr());
		System.out.println("req.getLocalName() : " + req.getLocalName());
		System.out.println("req.getRemoteAddr() : " + req.getRemoteAddr());
		System.out.println("req.getRemoteHost() : " + req.getRemoteHost());
		System.out.println("req.getRemotePort() : " + req.getRemotePort());
		System.out.println("req.getRequestURI() : " + req.getRequestURI());
		System.out.println("req.getRequestURL() : " + req.getRequestURL());
		
		resp.getWriter().write("hello world!");
	}

}
