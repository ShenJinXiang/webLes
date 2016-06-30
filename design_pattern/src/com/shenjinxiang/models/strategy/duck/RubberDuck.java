package com.shenjinxiang.models.strategy.duck;

import com.shenjinxiang.models.strategy.behavior.fly.FlyNoWay;
import com.shenjinxiang.models.strategy.behavior.quack.Quack;

public class RubberDuck extends Duck {
	
	public RubberDuck() {
		this.setFlyBehavior(new FlyNoWay());
		this.setQuackBehavior(new Quack());
	}

	@Override
	public void display() {
		System.out.println("橡皮鸭～～");
	}

}
