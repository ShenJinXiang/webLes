package com.shenjinxiang.models.strategy.behavior.quack;

public class MuteQuack implements QuackBehavitor {

	@Override
	public void quack() {
		System.out.println("<< Silence >>");
	}

}
