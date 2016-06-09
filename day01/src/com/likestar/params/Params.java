package com.likestar.params;

public class Params {

	/**
	 * 计算和 参数可变
	 * @param nums
	 * @return
	 */
	public static int sum(int ...nums) {
		int sum = 0;
		for(int num : nums) {
			sum += num;
		}
		return sum;
	}
	
	/**
	 * 获取最大值
	 * @param nums
	 * @return
	 */
	public static int max(int ...nums) {
		int max = Integer.MIN_VALUE;
		for(int num : nums) {
			max = (num > max) ? num : max;
		}
		return max;
	}
}
