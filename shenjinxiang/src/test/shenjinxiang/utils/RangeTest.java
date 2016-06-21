package test.shenjinxiang.utils;

import static org.junit.Assert.*;

import org.junit.Test;

import com.shenjinxiang.utils.Range;

public class RangeTest {

	@Test
	public void testRangeInt() {
		int[] range10 = Range.range(10);
		printIntArray(range10);
		int[] range0 = Range.range(0);
		printIntArray(range0);
		int[] range_1 = Range.range(-1);
		printIntArray(range_1);
	}

	@Test
	public void testRangeIntInt() {
		int[] range1_10 = Range.range(1, 10);
		printIntArray(range1_10);
		int[] range_1_10 = Range.range(-1, 10);
		printIntArray(range_1_10);
		int[] range10_1 = Range.range(10, 1);
		printIntArray(range10_1);
	}

	@Test
	public void testRangeIntIntInt() {
		int[] range1_10_2 = Range.range(1, 10, 2);
		printIntArray(range1_10_2);
		int[] range1_10_3 = Range.range(1, 10, 3);
		printIntArray(range1_10_3);
		int[] range_1_10_3 = Range.range(-1, 10, 3);
		printIntArray(range_1_10_3);
	}
	
	private void printIntArray(int[] arr) {
		System.out.print("size : " + arr.length + "    arr : ");
		for(int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}
