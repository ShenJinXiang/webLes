package com.shenjinxiang.models.factory.games;

public class WOW implements IGame {
	
	private WOW(){}

	@Override
	public void say() {
		System.out.println("wow!!!");
	}

	public static GameFactory getFactory() {
		return new GameFactory() {
			
			@Override
			public IGame createGame() {
				return new WOW();
			}
		};
	}

}
