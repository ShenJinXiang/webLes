package com.shenjinxiang.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		test2(req, resp);
	}
	
	
	private void test1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("****************");
		InputStream in = req.getInputStream();
		int len = 0;
		byte buffer[] =  new byte[1024];
		while((len = in.read(buffer)) > 0) {
			System.out.println(new String(buffer, 0, len));
		}
	}
	
	private void test2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			upload.setProgressListener(new ProgressListener() {
				
				@Override
				public void update(long arg0, long arg1, int arg2) {
					System.out.println(arg0 + "   " + arg1);
				}
			});
			List<FileItem> list = upload.parseRequest(req);
			for(FileItem item : list) {
				if(item.isFormField()) {
					String fieldName = item.getFieldName();
					String fieldValue = item.getString();
					System.out.println(fieldName + " = " + fieldValue);
				} else {
					String fileName = item.getName();
					System.out.println(fileName);
					InputStream in = item.getInputStream();
					int len = 0;
					byte buffer[] = new byte[1024];
					while((len = in.read(buffer)) > 0) {
						
					}
				}
			}
		} catch ( Exception e) {
			e.printStackTrace();
		}
	}

}
