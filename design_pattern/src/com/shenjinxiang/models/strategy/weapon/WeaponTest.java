package com.shenjinxiang.models.strategy.weapon;

public class WeaponTest {

	public static void main(String[] args) {
		Role king = new King();
		king.play(new Sword());
		king.play();
		king.setWeapon(new Blade());
		king.play();
	}
}
