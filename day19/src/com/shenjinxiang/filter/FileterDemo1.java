package com.shenjinxiang.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileterDemo1 implements Filter {
	
	private FilterConfig config;

	@Override
	public void destroy() {
		System.out.println("***************************************");
		System.out.println("---------------------------------------");
		System.out.println("FileterDemo1 -----------------  destroy");
		System.out.println("---------------------------------------");
		System.out.println("***************************************");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		req.setCharacterEncoding(config.getInitParameter("encoding"));
		resp.setCharacterEncoding(config.getInitParameter("encoding"));
		System.out.println("FileterDemo1 before doFilter");
		System.out.println(req.getRequestURI());
		chain.doFilter(req, resp);
		System.out.println("FileterDemo1 after doFilter");
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
		System.out.println("***************************************");
		System.out.println("---------------------------------------");
		System.out.println("FileterDemo1 --------------------  init");
		System.out.println("---------------------------------------");
		System.out.println("***************************************");
	}

}
