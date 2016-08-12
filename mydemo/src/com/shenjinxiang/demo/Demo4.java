package com.shenjinxiang.demo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.apache.commons.codec.binary.Base64;



public class Demo4 {

	// UEsDBBQACAgIAMKdDEkAAAAAAAAAAAAAAAABAAAAMCtOK04rTkl7OnErEAEAUEsHCEEjzv0OAAAADQAAAA==

	public static void main(String[] args) throws Exception {
		System.out.println(Config.NAME);
	}
	
	public static void test1() throws Exception {
		File inputFile = new File("src/001.txt");
		File outputFile = new File("src/001.zip");
//		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		ZipOutputStream out = new ZipOutputStream (new FileOutputStream(outputFile));
		BufferedOutputStream bo = new BufferedOutputStream (out);
		out.putNextEntry(new ZipEntry(inputFile.getName()));
		
		FileInputStream in = new FileInputStream(inputFile);
		BufferedInputStream bi = new BufferedInputStream(in);  
		int b;
		while((b = bi.read()) != -1) {
			bo.write(b);
		}
		bo.flush();
		bo.close();
		bi.close();
		in.close();
	}
	
	public static void test2() throws Exception {
		String msg = "sfsfsdf呵呵";
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ZipOutputStream zout = new ZipOutputStream(out);
		zout.putNextEntry(new ZipEntry("0"));
		zout.write(msg.getBytes());
		zout.closeEntry();
		
		zout.flush();
		out.flush();
		byte[] s1 = out.toByteArray();
		zout.close();
		out.close();
		String result = new String(Base64.encodeBase64(s1), "utf-8");
		System.out.println(result);
	}
	
	public static void test3()  throws Exception{
		String msg = "UEsDBBQACAgIAMKdDEkAAAAAAAAAAAAAAAABAAAAMCtOK04rTkl7OnErEAEAUEsHCEEjzv0OAAAADQAAAA==";
		byte[] bs = Base64.decodeBase64(msg.getBytes());
		ByteArrayOutputStream out = new ByteArrayOutputStream ();
		ByteArrayInputStream in = new ByteArrayInputStream(bs);
		ZipInputStream zin = new ZipInputStream (in);
		zin.getNextEntry();
		byte[] buffer = new byte[1024];
		int offset = -1;
		while((offset = zin.read(buffer)) != -1) {
			out.write(buffer, 0, offset);
		}
		out.flush();
		String result = out.toString();
		zin.close();
		in.close();
		out.close();
		System.out.println(result);
	}
}
