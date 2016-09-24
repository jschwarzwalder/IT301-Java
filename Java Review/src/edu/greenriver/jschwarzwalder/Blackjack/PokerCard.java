/*
 * Jami Schwarzwalder
 * 9/22/2016 
 * PokerCard.java
 * A Poker Card from Standard 52 card deck
 */

package edu.greenriver.jschwarzwalder.Blackjack;

public class PokerCard extends PlayingCard {
	public enum Suit {
		HEARTS, DIAMOND, CLUBS, SPADES
	};

	public enum Rank {
		KING, QUEEN, JACK, ACE, TEN, NINE, EIGHT, SEVEN, SIX, FIVE, FOUR, THREE, TWO
	};
	private Suit suit;
	private Rank rank;


	
	/**
     * Creates a new Poker card with color, width, height suit and rank
     *
     * @param mColor the name of the card color
     * @param mWidth the width of the poker card
     * @param mHeight the height of the poker card
     * @param mSuit the suit of card selected from enum Suits
     * @param mRank the rank of the card selected from enum Ranks
     * 
     */
	public PokerCard(String mColor, int mWidth, int mHeight, 
			Suit mSuit, Rank mRank) {
		super(mColor, mWidth, mHeight);
		suit = mSuit;
		rank = mRank;

	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "a " + getColor() + " " + rank + " of " + suit  ;
	}
	
	

}
