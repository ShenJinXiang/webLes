package com.likestar.enumeration;

import org.junit.Test;

public class GradeTest {

	public void printGrade(Grade g) {
		System.out.println("**********************");
		System.out.println(g.getDesc());
		System.out.println(g.getZhDesc());
		System.out.println("**********************");
	}
	
	@Test
	public void test1() {
		printGrade(Grade.A);
		printGrade(Grade.B);
		printGrade(Grade.C);
		printGrade(Grade.D);
		printGrade(Grade.E);
	}
}
