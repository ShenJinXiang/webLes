package com.qysoft.utils;

import java.io.UnsupportedEncodingException;

import org.apache.xmlbeans.impl.util.Base64;

import sun.applet.Main;

public class Base64Util {

	public static String encode(String str) {
		try {
			byte[] bs = Base64.encode(str.getBytes("utf-8"));
			return new String(bs, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public static String decode(String str) {
		try {
			byte[] bs = Base64.decode(str.getBytes("utf-8"));
			return new String(bs, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public static byte[] encodeForByte(String str) {
		try {
			return Base64.encode(str.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static byte[] decodeForByte(String str) {
		try {
			return Base64.decode(str.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		String msg = "哈哈哈";
		String result = Base64Util.encode(msg);
		System.out.println(result);
		System.out.println(Base64Util.decode(result));
	}
}
