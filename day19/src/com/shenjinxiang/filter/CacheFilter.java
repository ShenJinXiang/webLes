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

public class CacheFilter implements Filter {
	
	private FilterConfig config;

	@Override
	public void destroy() {
		System.out.println("CacheFilter destroy !!!");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		String url = req.getRequestURI();
		int expires = 0;
		if(url.endsWith(".jpg")) {
			expires = Integer.parseInt(this.config.getInitParameter("jpg"));
		} else if (url.endsWith(".js")) {
			expires = Integer.parseInt(this.config.getInitParameter("js"));
		} else if (url.endsWith(".css")){
			expires = Integer.parseInt(this.config.getInitParameter("css"));
		}
		resp.setDateHeader("expires", System.currentTimeMillis() + expires * 60 * 1000);
		chain.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("CacheFilter init ~~~");
		this.config = config;
	}

}
