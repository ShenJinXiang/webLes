package com.shenjinxiang.servlet.response;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = this.getServletContext().getRealPath("/download/Earth and Moon.jpg");
		String filename = path.substring(path.lastIndexOf(File.separator) + 1);
		System.out.println("path --> " + path);
		System.out.println("filename --> " + filename);
		
		resp.setHeader("content-disposition", "attachment;filename=" + filename);
		
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(new File(path));
			out = resp.getOutputStream();
			int len = 0;
			byte[] buffer = new byte[1024];
			while((len = in.read(buffer)) > 0) {
				out.write(buffer, 0, len);
			}
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(out != null) {
				out.close();
			}
			if(in != null) {
				in.close();
			}
		}
	}

}
