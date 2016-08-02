package com.shenjinxiang.demo;

import java.io.IOException;

import org.apache.commons.codec.binary.Base64;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Demo1 {
	
	private static String src = "shenjinxiang";

	//c2hlbmppbnhpYW5n
	
	public static void main(String[] args) {
		jdkBase64(src);
		commonsCodesBase64(src);
		bouncyCastleBase64(src);
	}
	
	// jdk
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
	
	// commons codec
	public static void commonsCodesBase64(String src) {
		byte[] encodeBytes = Base64.encodeBase64(src.getBytes());
		System.out.println(new String(encodeBytes));
		
		byte[] decodeBytes = Base64.decodeBase64(encodeBytes);
		System.out.println(new String(decodeBytes));
	}
	
	// bouncy castle
	public static void bouncyCastleBase64(String src) {
		byte[] encodeBytes = org.bouncycastle.util.encoders.Base64.encode(src.getBytes());
		System.out.println(new String(encodeBytes));
		
		byte[] decodeBytes = org.bouncycastle.util.encoders.Base64.decode(encodeBytes);
		System.out.println(new String(decodeBytes));
		
	}
}
