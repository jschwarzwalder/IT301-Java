/*
	 * Jami Schwarzwalder
	 * 9/24/2016 
	 * Card.java
	 * A Card from Standard 52 card deck
	 */

package edu.greenriver.jschwarzwalder.cards;

public class Card {
		/**
		 * This enum has values for the 4 possible suits of a standard playing card.
		 * Each is listed as Plural Noun.
		 * 
		 * @author Jami
		 *
		 */
		public enum Suit {
			HEARTS("Red"), 
			DIAMONDS("Red"), 
			CLUBS("Black"), 
			SPADES("Black");
			
			private final String color;

			Suit(String color) {
				this.color = color;
			}

			/**
			 * Returns the String value of the current color of the card
			 * 
			 * @return String The current color of card
			 */
			public String getColor() {
				return color;
			}
		};

		/**
		 * This enum has values for the 13 possible ranks of a standard playing card
		 * including ACE, KING, QUEEN, and JACK. Ordered from Ace to King Numbers
		 * are represented as text For example 10 is TEN
		 * 
		 * @author Jami
		 *
		 */
		public enum Rank {
			ACE(11), 
			TWO(2), 
			THREE(3), 
			FOUR(4), 
			FIVE(5), 
			SIX(6), 
			SEVEN(7), 
			EIGHT(8), 
			NINE(9), 
			TEN(10), 
			JACK(10), 
			QUEEN(10), 
			KING(10);

			private final int value;

			Rank(int value) {
				this.value = value;
			}

			/**
			 * Returns the int value of the value of the card
			 * 
			 * @return int The value of card
			 */
			public int getValue() {
				return value;
			}
		};

		// stored values for this card
		private Suit suit;
		private Rank rank;

		/**
		 * Creates a new Poker card 
		 *      
		 * default value is ACE of SPADES
		 * 
		 */
		public Card(){
			suit = Suit.SPADES;
			rank = Rank.ACE;
			
		}
		
		/**
		 * Creates a new Poker card with suit and rank
		 *
		 * @param mSuit
		 *            the suit of card selected from enum Suits
		 * @param mRank
		 *            the rank of the card selected from enum Ranks
		 * 
		 */
		public Card(Suit mSuit, Rank mRank) {
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
		 * Returns the assigned value of the card
		 * 
		 * @return int of card's value
		 */
		public int getValue() {
			return rank.getValue();
		}
		
		/**
		 * Returns the String value of the current color of the card
		 * 
		 * @return String The current color of card
		 */
		public String getColor() {
			return suit.getColor();
		}

		/**
		 * Creates human readable description of card including color, rank and
		 * suit.
		 * 
		 * @return String that identifies color, rank, and suit of card
		 */
		@Override
		public String toString() {
			return "a " + getColor() + " " + rank + " of " + suit + ". Worth: " + getValue();
		}

	}


