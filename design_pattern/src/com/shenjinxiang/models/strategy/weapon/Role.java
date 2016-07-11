package com.shenjinxiang.models.strategy.weapon;

public class Role {

	private Weapon weapon;
	
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
	public void play() {
		this.weapon.play();
	}
	
	public void play(Weapon weapon) {
		this.weapon = weapon;
		weapon.play();
	}
}
