package com.shenjinxiang.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterDemo2 implements Filter {

	@Override
	public void destroy() {
		System.out.println("***************************************");
		System.out.println("---------------------------------------");
		System.out.println("FilterDemo2 -----------------  destroy");
		System.out.println("---------------------------------------");
		System.out.println("***************************************");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("FilterDemo2 before doFilter");
		chain.doFilter(req, resp);
		System.out.println("FilterDemo2 after doFilter");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("***************************************");
		System.out.println("---------------------------------------");
		System.out.println("FilterDemo2 ---------------------  init");
		System.out.println("---------------------------------------");
		System.out.println("***************************************");
	}

}
