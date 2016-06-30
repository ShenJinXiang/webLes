package com.shenjinxiang.models.strategy.test;

import com.shenjinxiang.models.strategy.duck.Duck;
import com.shenjinxiang.models.strategy.duck.MallarDuck;
import com.shenjinxiang.models.strategy.duck.RubberDuck;

public class StrategyTest {

	public static void main(String[] args) {
		Duck d1 = new MallarDuck();
		d1.display();
		d1.performFly();
		d1.performQuack();
		
		Duck d2 = new RubberDuck();
		d2.display();
		d2.performFly();
		d2.performQuack();
	}
}
