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

public class NoCacheFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("***************************************");
		System.out.println("---------------------------------------");
		System.out.println("FilterDemo2 -----------------  destroy");
		System.out.println("---------------------------------------");
		System.out.println("***************************************");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		resp.setDateHeader("Expires", -1);
		resp.setHeader("Cache-Control", "no-cache");
		resp.setHeader("Paragma", "no-cache");
		chain.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("***************************************");
		System.out.println("---------------------------------------");
		System.out.println("FilterDemo2 ---------------------  init");
		System.out.println("---------------------------------------");
		System.out.println("***************************************");
	}

}
