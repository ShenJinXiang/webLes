package com.shenjinxiang.filter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class GzipFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		MyResponse myResponse = new MyResponse(resp);
		chain.doFilter(req, myResponse);
		
		byte[] out = myResponse.getBuffer();
		byte gzipput[] = gzip(out);
		
		resp.setHeader("Content-encoding", "gzip");
		resp.setHeader("Content-length", gzipput.length + "");
		resp.getOutputStream().write(gzipput);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}
	
	public byte[] gzip(byte b[]) throws IOException {
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		GZIPOutputStream gout = new GZIPOutputStream(bout);
		gout.write(b);
		gout.close();
		return bout.toByteArray();
	}
	
	class MyResponse extends HttpServletResponseWrapper {
		
		private ByteArrayOutputStream bout = new ByteArrayOutputStream();
		private HttpServletResponse response;
		private PrintWriter pw;

		public MyResponse(HttpServletResponse response) {
			super(response);
			this.response = response;
		}

		@Override
		public ServletOutputStream getOutputStream() throws IOException {
			return new MyServletOutputStream(bout);
		}

		@Override
		public PrintWriter getWriter() throws IOException {
			pw = new PrintWriter(bout);
			return pw;
		}
		
		public byte[] getBuffer() {
			if(pw != null) {
				pw.close();
			}
			return bout.toByteArray();
		}
		
	}
	
	class MyServletOutputStream extends ServletOutputStream{

		private ByteArrayOutputStream bout;
		
		public MyServletOutputStream(ByteArrayOutputStream bout) {
			this.bout = bout;
		}
		@Override
		public void write(int b) throws IOException {
			bout.write(b);
		}
		
	}

}
