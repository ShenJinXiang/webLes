package com.shenjinxiang.request;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyRequest1 extends HttpServletRequestWrapper {
	
	private HttpServletRequest request;

	public MyRequest1(HttpServletRequest request) {
		super(request);
		this.request = request;
	}

	@Override
	public String getParameter(String name) {
		String value = this.request.getParameter(name);
		if(!this.request.getMethod().equalsIgnoreCase("get")) {
			return value;
		}
		if(value == null) {
			return null;
		}
		try {
			value = new String(value.getBytes("iso8859-1"), this.request.getCharacterEncoding());
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		return value;
	}

}
