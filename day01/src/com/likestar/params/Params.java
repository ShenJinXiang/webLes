package com.likestar.params;

public class Params {

	/**
	 * ����� �����ɱ�
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
	 * ��ȡ���ֵ
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
