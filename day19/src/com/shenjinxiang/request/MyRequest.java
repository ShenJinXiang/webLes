package com.shenjinxiang.request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class MyRequest implements HttpServletRequest {
	
	private HttpServletRequest request;
	
	public MyRequest(HttpServletRequest request) {
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

	@Override
	public Object getAttribute(String arg0) {
		return this.request.getAttribute(arg0);
	}

	@Override
	public Enumeration getAttributeNames() {
		return this.request.getAttributeNames();
	}

	@Override
	public String getCharacterEncoding() {
		return this.request.getCharacterEncoding();
	}

	@Override
	public int getContentLength() {
		return this.request.getContentLength();
	}

	@Override
	public String getContentType() {
		return this.request.getContentType();
	}

	@Override
	public ServletInputStream getInputStream() throws IOException {
		return this.request.getInputStream();
	}

	@Override
	public String getLocalAddr() {
		return this.request.getLocalAddr();
	}

	@Override
	public String getLocalName() {
		return this.request.getLocalName();
	}

	@Override
	public int getLocalPort() {
		return this.request.getLocalPort();
	}

	@Override
	public Locale getLocale() {
		return this.request.getLocale();
	}

	@Override
	public Enumeration getLocales() {
		return this.request.getLocales();
	}


	@Override
	public Map getParameterMap() {
		return this.request.getParameterMap();
	}

	@Override
	public Enumeration getParameterNames() {
		return this.request.getParameterNames();
	}

	@Override
	public String[] getParameterValues(String arg0) {
		return this.request.getParameterValues(arg0);
	}

	@Override
	public String getProtocol() {
		return this.request.getProtocol();
	}

	@Override
	public BufferedReader getReader() throws IOException {
		return this.request.getReader();
	}

	@Override
	public String getRealPath(String arg0) {
		return this.request.getRealPath(arg0);
	}

	@Override
	public String getRemoteAddr() {
		return this.request.getRemoteAddr();
	}

	@Override
	public String getRemoteHost() {
		return this.request.getRemoteHost();
	}

	@Override
	public int getRemotePort() {
		return this.request.getRemotePort();
	}

	@Override
	public RequestDispatcher getRequestDispatcher(String arg0) {
		return this.request.getRequestDispatcher(arg0);
	}

	@Override
	public String getScheme() {
		return this.request.getScheme();
	}

	@Override
	public String getServerName() {
		return this.request.getServerName();
	}

	@Override
	public int getServerPort() {
		return this.request.getServerPort();
	}

	@Override
	public boolean isSecure() {
		return this.request.isSecure();
	}

	@Override
	public void removeAttribute(String arg0) {
		this.request.removeAttribute(arg0);
	}

	@Override
	public void setAttribute(String arg0, Object arg1) {
		this.request.setAttribute(arg0, arg1);
	}

	@Override
	public void setCharacterEncoding(String arg0) throws UnsupportedEncodingException {
		this.request.setCharacterEncoding(arg0);
	}

	@Override
	public String getAuthType() {
		return this.request.getAuthType();
	}

	@Override
	public String getContextPath() {
		return this.request.getContextPath();
	}

	@Override
	public Cookie[] getCookies() {
		return this.request.getCookies();
	}

	@Override
	public long getDateHeader(String arg0) {
		return this.request.getDateHeader(arg0);
	}

	@Override
	public String getHeader(String arg0) {
		return this.request.getHeader(arg0);
	}

	@Override
	public Enumeration getHeaderNames() {
		return this.request.getHeaderNames();
	}

	@Override
	public Enumeration getHeaders(String arg0) {
		return this.request.getHeaders(arg0);
	}

	@Override
	public int getIntHeader(String arg0) {
		return this.request.getIntHeader(arg0);
	}

	@Override
	public String getMethod() {
		return this.request.getMethod();	
	}

	@Override
	public String getPathInfo() {
		return this.request.getPathInfo();	
	}

	@Override
	public String getPathTranslated() {
		return this.request.getPathTranslated();	
	}

	@Override
	public String getQueryString() {
		return this.request.getQueryString();
	}

	@Override
	public String getRemoteUser() {
		return this.request.getRemoteUser();
	}

	@Override
	public String getRequestURI() {
		return this.request.getRequestURI();
	}

	@Override
	public StringBuffer getRequestURL() {
		return this.request.getRequestURL();
	}

	@Override
	public String getRequestedSessionId() {
		return this.request.getRequestedSessionId();
	}

	@Override
	public String getServletPath() {
		return this.request.getServletPath();
	}

	@Override
	public HttpSession getSession() {
		return this.request.getSession();
	}

	@Override
	public HttpSession getSession(boolean arg0) {
		return this.request.getSession(arg0);
	}

	@Override
	public Principal getUserPrincipal() {
		return this.request.getUserPrincipal();
	}

	@Override
	public boolean isRequestedSessionIdFromCookie() {
		return this.request.isRequestedSessionIdFromCookie();
	}

	@Override
	public boolean isRequestedSessionIdFromURL() {
		return this.request.isRequestedSessionIdFromURL();
	}

	@Override
	public boolean isRequestedSessionIdFromUrl() {
		return this.request.isRequestedSessionIdFromUrl();
	}

	@Override
	public boolean isRequestedSessionIdValid() {
		return this.request.isRequestedSessionIdValid();
	}

	@Override
	public boolean isUserInRole(String arg0) {
		return this.request.isUserInRole(arg0);
	}

}
