/*
 * Jami Schwarzwalder
 * 9/22/2016 
 * CardGameTest.java
 * Class to shuffle and build deck of cards
 */

package edu.greenriver.jschwarzwalder.Blackjack;

import java.util.Arrays;
import java.util.Random;

public class CardGameTest {
	private static Card[] cardDeck = new Card[52];
	private static int WIDTH = 250; // in pixels
	private static int HEIGHT = 350; // in pixels
	private static String color = "white"; //default value in case error
	private static Random randNum = new Random();
	
	//creates a deck of cards with all the suits and ranks from enums
	//calculates color based on Suit
	private static void buildDeck() {
		int index = 0;
		for (Card.Suit suit : Card.Suit.values()) {
			
			if (suit == Card.Suit.HEARTS || suit == Card.Suit.DIAMONDS) {
				color = "red";
			} else if (suit == Card.Suit.CLUBS || suit == Card.Suit.SPADES) {
				color = "black";
			} else {
				// test if there is an error
				//color should never result in white
				color = "white";
			}
			for (Card.Rank rank : Card.Rank.values()) {
				Card card = new Card(color, WIDTH, HEIGHT, suit, rank);
				cardDeck[index] = card;
				index++;
				
			}

		}
	}
	
	//goes through all cards in deck and swaps value with value in random position
	private static void randomize(Card[] deck) {
		for (int i = 0; i < deck.length; i++) {
			int swapPosition = randNum.nextInt(52);
			if (i != swapPosition) {
				Card currentValue = deck[i];
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
	
	/**
	 * Print out the the names of cards in the console one line per card
	 */
	public static void printCards(){
		System.out.println("Deck: ");
		for(int i = 0 ; i < cardDeck.length; i++){
			System.out.println("   " + cardDeck[i] );
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
