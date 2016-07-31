package com.shenjinxiang.demo;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.junit.Test;

public class Demo8 {

	@Test
	public void test1() throws IOException {
		URL url = new URL("http://www.baidu.com");
		URLConnection conn = url.openConnection();
		InputStream in = conn.getInputStream();
		byte[] buff = new byte[1024];
		int len = 0;
		while((len = in.read(buff)) != -1) {
			System.out.println(new String(buff, 0, len));
		}
	}
}
