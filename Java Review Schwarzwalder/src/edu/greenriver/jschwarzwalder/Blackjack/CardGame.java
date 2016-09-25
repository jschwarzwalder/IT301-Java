package edu.greenriver.jschwarzwalder.Blackjack;

public abstract class CardGame {
	
	protected String name;
	protected String welcomeMessage;
	
	
	public CardGame(String name, String welcomeMessage) {
		this.name = name;
		this.welcomeMessage = welcomeMessage;
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
