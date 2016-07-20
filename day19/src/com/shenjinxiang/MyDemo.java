package com.shenjinxiang;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class MyDemo {

	public static void main(String[] args) {
		String str = "123456";
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte md5[] = md.digest(str.getBytes());
			for(byte b : md5) {
				System.out.print(b);
			}
			System.out.println();
			byte[] bs = Base64.getEncoder().encode(md5);
			for(byte b : bs) {
				System.out.print(b);
			}
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
}
