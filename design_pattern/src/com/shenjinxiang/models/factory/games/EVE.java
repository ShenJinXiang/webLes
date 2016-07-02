package com.shenjinxiang.models.factory.games;

public class EVE implements IGame {

	private EVE(){}
	
	public static GameFactory getFactory() {
		return new GameFactory() {

			@Override
			public IGame createGame() {
				return new EVE();
			}
			
		};
	}
	@Override
	public void say() {
		System.out.println("eve online!");
	}
	
	

}
