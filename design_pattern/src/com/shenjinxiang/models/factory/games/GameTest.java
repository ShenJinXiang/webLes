package com.shenjinxiang.models.factory.games;

public class GameTest {

	public static void main(String[] args) {
		IGame g1 = EVE.getFactory().createGame();
		IGame g2 = WOW.getFactory().createGame();
		g1.say();
		g2.say();
	}
}
