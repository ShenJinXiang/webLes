package com.shenjinxiang.models.strategy.duck;

import com.shenjinxiang.models.strategy.behavior.fly.FlyWithWings;
import com.shenjinxiang.models.strategy.behavior.quack.Quack;

public class MallarDuck extends Duck {
	
	public MallarDuck() {
		this.setFlyBehavior(new FlyWithWings());
		this.setQuackBehavior(new Quack());
	}

	@Override
	public void display() {
		System.out.println("绿头鸭～～～");
	}

}
