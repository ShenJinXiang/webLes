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

import com.shenjinxiang.request.MyRequest;
import com.shenjinxiang.request.MyRequest1;

public class CharacterFilter implements Filter {
	
	@Override
	public void destroy() {
		System.out.println("***************************************");
		System.out.println("---------------------------------------");
		System.out.println("CharacterFilter destroy");
		System.out.println("---------------------------------------");
		System.out.println("***************************************");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("CharacterFilter before");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpServletRequest requ = new MyRequest1(req);
		chain.doFilter(requ, resp);
		System.out.println("CharacterFilter after");
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("***************************************");
		System.out.println("---------------------------------------");
		System.out.println("CharacterFilter init");
		System.out.println("---------------------------------------");
		System.out.println("***************************************");
	}

}
