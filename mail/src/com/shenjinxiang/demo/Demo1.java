package com.shenjinxiang.demo;

import java.io.IOException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Demo1 {
	
	private static String src = "shenjinxiang";

	//c2hlbmppbnhpYW5n
	
	public static void main(String[] args) {
		jdkBase64(src);
	}
	
	public static void jdkBase64(String str) {
		try {
			BASE64Encoder encoder = new BASE64Encoder();
			String result = encoder.encode(str.getBytes());
			System.out.println(result);
			
			BASE64Decoder decoder = new BASE64Decoder();
			byte[] bs = decoder.decodeBuffer(result);
			System.out.println(new String(bs));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
