package com.shenjinxiang.models.decorate.beverage;

public class BeverageTest {

	public static void main(String[] args) {
		Beverage beverage = new Espresso();
		System.out.println(beverage.getDescription() + "$" + beverage.cost());
		beverage = new Mocha(beverage);
		System.out.println(beverage.getDescription() + "$" + beverage.cost());
		beverage = new Soy(beverage);
		System.out.println(beverage.getDescription() + "$" + beverage.cost());
		beverage = new Whip(beverage);
		System.out.println(beverage.getDescription() + "$" + beverage.cost());
	}

}
