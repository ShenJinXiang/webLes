package com.shenjinxiang.utils;

import com.shenjinxiang.Exceptions.WrongParameterException;

/**
 * 
 * <p>Title: Range</p>
 * <p>Description: 一定范围内的数组</p>
 * <p>Company: </p>
 * @author shenjinxiang
 *
 */
public class Range {

	/**
	 * 从0到n之间的数组（不包括n）
	 * @param n	取值范围
	 * @return
	 */
	public static int[] range(int n) {
		if(n < 0) {
			throw new WrongParameterException("参数错误，取值范围必须为正整数");
		}
		int[] result = new int[n];
		for(int i = 0; i < n; i++) {
			result[i] = i;
		}
		return result;
	}
	
	/**
	 * 从start到end之间的数组 （不包括end）
	 * @param start 开始数值
	 * @param end 结束数值
	 * @return
	 */
	public static int[] range(int start, int end) {
		if(start > end) {
			throw new WrongParameterException("参数错误，start 必须不大于 end");
		}
		int size = end - start;
		int[] result = new int[size];
		for(int i = 0; i < size; i++){
			result[i] = start + i;
		}
		return result;
	}
	
	/**
	 * 从start到end之间的数组 （不包括end）
	 * @param start 开始数值
	 * @param end 结束数值
	 * @param step 步长
	 * @return
	 */
	public static int[] range(int start, int end, int step) {
		if(start > end) {
			throw new WrongParameterException("参数错误，start 必须不大于 end");
		}
		if(step <= 0) {
			throw new WrongParameterException("参数错误，step 必须为正整数");
		}
		int size = (end - start) / step;
		int[] result = new int[size];
		for(int i = 0; i < size; i++) {
			result[i] = start + (i * step);
		}
		return result;
	}
}
