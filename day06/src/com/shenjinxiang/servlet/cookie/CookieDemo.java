package com.shenjinxiang.servlet.cookie;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieDemo extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cookies = req.getCookies();
		long lastLoginTime = -1;
		for(Cookie cookie : cookies){
			if("lastLoginTime".equals(cookie.getName())) {
				lastLoginTime = Long.parseLong(cookie.getValue());
			}
		}
		String msg = null;
		if(lastLoginTime != -1) {
			Date date = new Date(lastLoginTime);
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
			msg = "<p>你上次访问时间是：" + sdf.format(date) + "</p>";
		} else {
			msg = "<p>欢迎您，新来的！</p>";
		}
		
		Cookie cookie = new Cookie("lastLoginTime", System.currentTimeMillis() + "");
		cookie.setMaxAge(30 * 24 * 3600);
		cookie.setPath(req.getContextPath());
		resp.addCookie(cookie);
		
		resp.setHeader("Content-Type", "text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(msg);
	}

	
}
