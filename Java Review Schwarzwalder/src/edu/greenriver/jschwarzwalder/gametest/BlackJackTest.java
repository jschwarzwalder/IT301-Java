/*
	 * Jami Schwarzwalder
	 * 9/24/2016 
	 * BlackJackTest.java
	 * Plays one round of Blackjack.
	 */

package edu.greenriver.jschwarzwalder.gametest;

import edu.greenriver.jschwarzwalder.Blackjack.BlackjackGame;

public abstract class BlackJackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlackjackGame game = new BlackjackGame("Blackjack", "Welcome to my BlackJack Game!");
		game.playRound();
	}

}
