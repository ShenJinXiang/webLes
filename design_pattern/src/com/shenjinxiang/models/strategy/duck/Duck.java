package com.shenjinxiang.models.strategy.duck;

import com.shenjinxiang.models.strategy.behavior.fly.FlyBehavior;
import com.shenjinxiang.models.strategy.behavior.quack.QuackBehavitor;

public abstract class Duck {

	private FlyBehavior flyBehavior;
	private QuackBehavitor quackBehavior;
	
	public abstract void display();
	
	public void performFly() {
		flyBehavior.fly();
	}
	
	public void performQuack() {
		quackBehavior.quack();
	}
	
	public void swim() {
		System.out.println("All ducks float, even decoys!");
	}

	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}

	public void setQuackBehavior(QuackBehavitor quackBehavior) {
		this.quackBehavior = quackBehavior;
	}
	
}
