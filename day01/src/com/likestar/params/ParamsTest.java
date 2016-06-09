package com.likestar.params;

import static org.junit.Assert.*;

import org.junit.Test;

public class ParamsTest {

	@Test
	public void testSum() {
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int sum = Params.sum(nums);
		System.out.println(nums);
		System.out.println("sum -> " + sum);
		System.out.println("1 + 2 + 3 + 4 + 5 = " + Params.sum(1, 2, 3, 4, 5));
	}

	@Test
	public void testMax() {
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int max = Params.max(nums);
		System.out.println(nums);
		System.out.println("max -> " + max);
	}

}
