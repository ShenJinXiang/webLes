package com.likestar.enumeration;

import org.junit.Test;

public class EgradeTest {

	public void printEgrade(Egrade e) {
		System.out.println("-------------------------------");
		System.out.println(e.getDesc());
		System.out.println(e.getZhDesc());
		System.out.println("-------------------------------");
	}
	
	@Test
	public void test1(){
		printEgrade(Egrade.A);
		printEgrade(Egrade.B);
		printEgrade(Egrade.C);
		printEgrade(Egrade.D);
		printEgrade(Egrade.E);
	}
}
