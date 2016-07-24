package com.shenjinxiang.demo;

import org.junit.Test;

public class Demo5 {

	public <T> void reverse(T arr[]) {
		int startIndex = 0;
		int endIndex = arr.length - 1;
		
		while(true) {
			if(startIndex >= endIndex) {
				break;
			}
			T temp = arr[startIndex];
			arr[startIndex] = arr[endIndex];
			arr[endIndex] = temp;
			startIndex++;
			endIndex--;
		}
	}
	
	@Test
	public void test1() {
		Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		for(int i : arr) {
			System.out.print(i + "\t");
		}
		System.out.println();
		
		reverse(arr);
		for(int i : arr) {
			System.out.print(i + "\t");
		}
		System.out.println();
	}
}
