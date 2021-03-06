/*
	 * Jami Schwarzwalder
	 * 9/24/2016 
	 * BlackJackGame.java
	 * A subclass of CardGame to play a simplified version of blackjack.
	 */
package edu.greenriver.jschwarzwalder.blackjackgame;

import java.util.Random;

import edu.greenriver.jschwarzwalder.cardgame.CardGame;
import edu.greenriver.jschwarzwalder.cards.Card;
import edu.greenriver.jschwarzwalder.console.Console;

public class BlackjackGame extends CardGame {

	/**
	 * The number of cards in deck of cards 
	 */
	private static final int DECK_SIZE = 52;

	/**
	 * The number of cards initially dealt to player 
	 */
	private static final int FIRST_DEAL = 2;

	/**
	 * The number of points that player can be greater than or equal too 
	 * before loosing round.
	 */
	private static final int BUST_THRESHOLD = 21;

	/**
	 * The number of times you shuffle the deck of cards
	 */
	private static final int NUM_OF_SHUFFLES = 3;

	/**
	 * The maximum value at which the dealer will stop hitting
	 */
	private static final int DEALER_MAX = 16;

	private Card[] cardDeck = new Card[DECK_SIZE];
	private static Random randNum = new Random();

	private int deckIndex = 0;
	private int playerHand = 0;
	private int dealerHand = 0;

	/**
	 * builds a Blackjack Game with a printout of the name of the game and a
	 * welcome message
	 * 
	 * @param name
	 *            Title of game
	 * @param welcomeMessage
	 *            Message for player
	 */
	public BlackjackGame(String name, String welcomeMessage) {
		super(name, welcomeMessage);
		buildDeck();
		playerHand = 0;
		dealerHand = 0;
		shuffle();
	}

	/**
	 * This method will shuffle the deck of cards being used in the game
	 */
	@Override
	public void shuffle() {
		for (int i = 0; i < NUM_OF_SHUFFLES; i++) {
			randomize(cardDeck);
		}
		deckIndex = 0;

	}

	/**
	 * Deals a single card from the deck to the user
	 * 
	 * @return Card from deck
	 */
	@Override
	public Card deal() {
		Card dealCard = cardDeck[deckIndex];
		deckIndex++;
		return dealCard;
	}

	/**
	 * Plays a single hand in the game
	 */
	@Override
	public void playRound() {
		playerHand = 0;
		dealerHand = 0;
		for (int i = 1; i <= FIRST_DEAL; i++) {
			dealtoPlayer();
		}
		printPlayerTotal();
		boolean dealerAction = hitAction();
		if (dealerAction) {
			while (dealerHand <= DEALER_MAX) {
				dealToDealer();
			}
			if (dealerHand > BUST_THRESHOLD) {
				Console.print("Dealer Busts");
				Console.print("Player Wins!");
			} else if (playerHand >= dealerHand) {
				Console.print("Player Wins!");
			} else {
				Console.print("Dealer Wins!");
			}
		}

		shuffle();
	}

	private void buildDeck() {
		int index = 0;
		for (Card.Suit suit : Card.Suit.values()) {
			for (Card.Rank rank : Card.Rank.values()) {
				Card card = new Card(suit, rank);
				cardDeck[index] = card;
				index++;

			}

		}
	}
	
	//Switch position of each card in array with a random position.
	private void randomize(Card[] deck) {
		for (int i = 0; i < deck.length; i++) {
			int swapPosition = randNum.nextInt(52);
			if (i != swapPosition) {
				Card currentValue = deck[i];
				deck[i] = deck[swapPosition];
				deck[swapPosition] = currentValue;
			}
		}

	}

	private void dealtoPlayer() {
		Card dealtCard = deal();
		Console.print("You are dealt a(n) " + dealtCard.getRank() + " of " + dealtCard.getSuit());
		playerHand += dealtCard.getValue();
	}

	private void dealToDealer() {
		Card dealtCard = deal();
		Console.print("Dealer Dealt " + dealtCard.getRank() + " of " + dealtCard.getSuit());
		dealerHand += dealtCard.getValue();
		Console.print("Dealer total: " + dealerHand);
	}

	private void printPlayerTotal() {
		Console.print("Total: " + playerHand);
	}

	// returns true if the game should continue, false otherwise
	private boolean hitAction() {
		String Hit = Console.getString("Hit? (Y/N)");
		if (Hit.equalsIgnoreCase("Y")) {
			dealtoPlayer();
			printPlayerTotal();
			if (playerHand > BUST_THRESHOLD) {
				Console.print("Bust");
				Console.print("Dealer wins!");
				return false;
			}
			return hitAction();

		} else if (!Hit.equalsIgnoreCase("N")) {
			Console.print("InvalidInput");
			return hitAction();
		}
		return true;
	}

}
