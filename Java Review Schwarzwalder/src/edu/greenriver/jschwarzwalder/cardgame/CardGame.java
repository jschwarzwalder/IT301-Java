/*
	 * Jami Schwarzwalder
	 * 9/24/2016 
	 * CardGame.java
	 * Abstrct CardGame class.
	 */
package edu.greenriver.jschwarzwalder.cardgame;

import edu.greenriver.jschwarzwalder.cards.Card;
import edu.greenriver.jschwarzwalder.console.Console;

public abstract class CardGame {
	
	protected String name;
	protected String welcomeMessage;
	
	/**
	 * builds a Card Game with a printout of the name of the game and a welcome message
	 * @param name Title of game
	 * @param welcomeMessage Message for player
	 */
	public CardGame(String name, String welcomeMessage) {
		this.name = name;
		this.welcomeMessage = welcomeMessage;
		Console.print("Play a " + name + " game!");
		Console.print(welcomeMessage);
	}

	/**
	 * This method will shuffle the deck of cards being used in the game
	 */
	public abstract void shuffle();
	
	/**
	 * Deals a single card from the deck to the user 
	 * 
	 * @return Card from deck
	 */
	public abstract Card deal();
	
	/**
	 * Plays a single hand in the game
	 */
	public abstract void playRound();
	

}
