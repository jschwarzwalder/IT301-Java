package edu.greenriver.jschwarzwalder.Blackjack;

import java.util.Arrays;

public class CardGameTest {
	private static PokerCard[] cardDeck = new PokerCard[52];
	private static int WIDTH = 250; //in pixels
	private static int HEIGHT = 350; //in pixels
	private static String color = "white";

	private static void buildDeck() {
		int index = 0;
		for (PokerCard.Suit suit : PokerCard.Suit.values()) {
			if (suit == PokerCard.Suit.HEARTS || suit == PokerCard.Suit.DIAMOND){
				color = "red";
			} else if (suit == PokerCard.Suit.CLUBS || suit == PokerCard.Suit.SPADES){
				color = "black";
			} else {
				//test if there is an error
				color ="white";
			}
			for(PokerCard.Rank rank : PokerCard.Rank.values()){
				
				PokerCard card = new PokerCard(color, WIDTH, HEIGHT, suit, rank);
				cardDeck[index] = card;
				index ++;
				
			}

		}
	}
	
	public static void main(String[] args){
		buildDeck();
		System.out.println(Arrays.toString(cardDeck));
	}
}
