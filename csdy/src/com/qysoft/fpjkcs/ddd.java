package com.qysoft.fpjkcs;

import java.io.IOException;

import sun.misc.BASE64Decoder;

public class ddd {

	public static void main(String[] args) throws IOException {
		String str = "5byA56Wo54K55L+h5oGv6ZSZ6K+v";
		String result = new String(new BASE64Decoder().decodeBuffer(str));
		System.out.println(result);
	}
}
