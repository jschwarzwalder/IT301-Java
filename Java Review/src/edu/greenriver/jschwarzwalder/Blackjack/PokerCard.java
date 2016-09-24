/*
 * Jami Schwarzwalder
 * 9/22/2016 
 * PokerCard.java
 * A Poker Card from Standard 52 card deck
 */

package edu.greenriver.jschwarzwalder.Blackjack;

public class PokerCard extends PlayingCard {
	/**
	 * This enum has values for the 4 possible suits of a standard
	 * playing card. Each is listed as Plural Noun.
	 * 
	 * @author Jami
	 *
	 */
	public enum Suit {
		HEARTS, DIAMONDS, CLUBS, SPADES
	};

	/**
	 * This enum has values for the 13 possible ranks of a standard
	 * playing card including ACE, KING, QUEEN, and JACK. 
	 * Numbers are represented as text For example 10 is TEN
	 * 
	 * @author Jami
	 *
	 */
	public enum Rank {
		KING, QUEEN, JACK, ACE, TEN, NINE, EIGHT, SEVEN, SIX, FIVE, FOUR, THREE, TWO
	};
	
	//stored values for this card
	private Suit suit;
	private Rank rank;

	/**
	 * Creates a new Poker card with color, width, height suit and rank
	 *
	 * @param mColor
	 *            the name of the card color
	 * @param mWidth
	 *            the width of the poker card
	 * @param mHeight
	 *            the height of the poker card
	 * @param mSuit
	 *            the suit of card selected from enum Suits
	 * @param mRank
	 *            the rank of the card selected from enum Ranks
	 * 
	 */
	public PokerCard(String mColor, int mWidth, int mHeight, Suit mSuit, Rank mRank) {
		super(mColor, mWidth, mHeight);
		suit = mSuit;
		rank = mRank;

	}

	/**
	 * Returns the assigned suit of the card
	 * 
	 * @return suit of card from Suit enum
	 */
	public Suit getSuit() {
		return suit;
	}

	/**
	 * Sets the suit of the card to one from Suit enum
	 * 
	 * @param suit
	 *            from enum Suit
	 */
	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	/**
	 * Returns the assigned rank of the card
	 * 
	 * @return rank of card from Rank enum
	 */
	public Rank getRank() {
		return rank;
	}

	/**
	 * Sets the Rank of the card to one from Rank enum
	 * 
	 * @param rank
	 *            from enum Rank
	 */
	public void setRank(Rank rank) {
		this.rank = rank;
	}

	/**
	 * Creates human readable description of card including color, rank and
	 * suit.
	 * 
	 * @return String that identifies color, rank, and suit of card
	 */
	@Override
	public String toString() {
		return "a " + getColor() + " " + rank + " of " + suit;
	}

}
