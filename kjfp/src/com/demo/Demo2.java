package com.demo;

import java.io.IOException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Demo2 {

	public static void main(String[] args) throws IOException {
		String msg = "5byA56Wo54K55L+h5oGv6ZSZ6K+v";
		String result = new String(new BASE64Decoder().decodeBuffer(msg));
		System.out.println(result);
		
	}
}
