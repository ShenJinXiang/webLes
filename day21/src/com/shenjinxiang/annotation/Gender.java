package com.shenjinxiang.annotation;

public enum Gender {

//	MALE, FEMALE;
	男(1),  女(0);
	
	private int val;
	
	private Gender(int val) {
		this.val = val;
	}
}
