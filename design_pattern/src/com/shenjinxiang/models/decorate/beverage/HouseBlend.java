package com.shenjinxiang.models.decorate.beverage;

public class HouseBlend extends Beverage {
	
	public HouseBlend() {
		System.out.println("house blend coffee");
	}

	@Override
	public double cost() {
		return 0.89;
	}

}
