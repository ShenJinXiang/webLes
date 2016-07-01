package com.shenjinxiang.tags;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

public class ViewIpTag extends TagSupport {


	@Override
	public void setPageContext(PageContext pageContext) {
		System.out.println("setPageContext");
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
		JspWriter out = pageContext.getOut();
		String ip = request.getRemoteAddr();
		try {
			out.write(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
