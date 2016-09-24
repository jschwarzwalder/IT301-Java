package edu.greenriver.jschwarzwalder.Blackjack;

import java.util.Arrays;
import java.util.Random;

public class CardGameTest {
	private static PokerCard[] cardDeck = new PokerCard[52];
	private static int WIDTH = 250; // in pixels
	private static int HEIGHT = 350; // in pixels
	private static String color = "white"; //default value in case error
	private static Random randNum = new Random();
	
	//creates a deck of cards with all the suits and ranks from enums
	//calculates color based on Suit
	private static void buildDeck() {
		int index = 0;
		for (PokerCard.Suit suit : PokerCard.Suit.values()) {
			if (suit == PokerCard.Suit.HEARTS || suit == PokerCard.Suit.DIAMONDS) {
				color = "red";
			} else if (suit == PokerCard.Suit.CLUBS || suit == PokerCard.Suit.SPADES) {
				color = "black";
			} else {
				// test if there is an error
				//color should never result in white
				color = "white";
			}
			for (PokerCard.Rank rank : PokerCard.Rank.values()) {

				PokerCard card = new PokerCard(color, WIDTH, HEIGHT, suit, rank);
				cardDeck[index] = card;
				index++;

			}

		}
	}
	
	//goes through all cards in deck and swaps value with value in random position
	private static void randomize(PokerCard[] deck) {
		for (int i = 0; i < deck.length; i++) {
			int swapPosition = randNum.nextInt(52);
			if (i != swapPosition) {
				PokerCard currentValue = deck[i];
				deck[i] = deck[swapPosition];
				deck[swapPosition] = currentValue;
			}
		}

	}

	/**
	 * Shuffle the deck of cards for n times
	 * 
	 * @param numofShuffles
	 *            Number of times to shuffle the deck of cards
	 */
	public static void shuffle(int numofShuffles) {
		for (int i = 0; i < numofShuffles; i++) {
			randomize(cardDeck);
		}
	}
	
	
	/**
	 * Print out the the names of cards in the console on one line
	 */
	public static void printDeck() {
		System.out.println(Arrays.toString(cardDeck));
	}
	
	public static void printCards(){
		System.out.println("Deck: \n");
		for(int i = 0 ; i < cardDeck.length; i++){
			System.out.println("   " + cardDeck[i] + " \n");
		}
	}

	/**
	 * This is main, used to call private methods and test they work
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		buildDeck();
		shuffle(3);
		printDeck();
		printCards();

	}

}
