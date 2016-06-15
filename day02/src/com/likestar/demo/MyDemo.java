package com.likestar.demo;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

public class MyDemo {

	@Test
	public void test1() {
		int num = 9;
		int[][] arr = new int[3][9];
		
		int x = 2, y = 0;
		boolean order = false;
		
		for(int i = 1; i <= num; i++) {
			arr[x][y] = i;
			y++;
			if(!order) {
				x--;
			}
			if(order) {
				x++;
			}
			if(x < 0) {
				order = true;
				x = x + 2;
			}
			if (x > 2) {
				order = false;
				x = x - 2;
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print((arr[i][j] == 0) ? (" ") : (arr[i][j]));
			}
			System.out.println();
		}
	}
	
	
	@Test
	public void test2() {
		int num = 45;
		int row = num / 4 + 1;
		int col = num;
		int[][] arr = new int[row][col];
		
		int x = row - 1, y = 0;
		boolean order = false;
		
		for(int i = 1; i <= col; i++) {
			arr[x][y] = i;
			y++;
			if(!order) {
				x--;
			}
			if(order) {
				x++;
			}
			if(x < 0) {
				order = true;
				x = x + 2;
			}
			if (x > row - 1) {
				order = false;
				x = x - 2;
			}
		}
		int l = (num + "").length();
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.printf("%" + l + "s", (arr[i][j] == 0) ? (" ") : (arr[i][j]));
			}
			System.out.println();
		}
	}
	
	@Test
	public void test3() throws Exception{
		ServerSocket server = new ServerSocket(8899);
		Socket socket = server.accept();
		
		FileInputStream is = new FileInputStream("src/test.html");
		OutputStream os = socket.getOutputStream();
		
		int len = 0;
		byte buff[] = new byte[1024];
		while((len = is.read(buff)) > 0) {
			os.write(buff, 0, len);
		}
		
		is.close();
		os.flush();
		os.close();
		socket.close();
		server.close();
	}
}
