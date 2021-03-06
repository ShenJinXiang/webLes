package com.shenjinxiang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String text = req.getParameter("text");
		System.out.println("username -> " + username);
		System.out.println("password -> " + password);
		System.out.println("text -> " + text);
		req.setAttribute("username", username);
		req.setAttribute("password", password);
		req.setAttribute("text", text);
		req.getRequestDispatcher("WEB-INF/jsp/demo1.jsp").forward(req, resp);
	}

}
