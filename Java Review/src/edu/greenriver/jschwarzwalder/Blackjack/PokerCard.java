package edu.greenriver.jschwarzwalder.Blackjack;

public class PokerCard extends PlayingCards {
	private Suits suit;
	private Ranks rank;

	public enum Suits {
		HEARTS, DIAMOND, CLUBS, SPADES
	};

	public enum Ranks {
		KING, QUEEN, JACK, ACE, TEN, NINE, EIGHT, SEVEN, SIX, FIVE, FOUR, THREE, TWO
	};

	public PokerCard(String mColor, int mWidth, int mHeight, 
			Suits mSuit, Ranks mRank) {
		super(mColor, mWidth, mHeight);
		suit = mSuit;
		rank = mRank;

	}

	public Suits getSuit() {
		return suit;
	}

	public void setSuit(Suits suit) {
		this.suit = suit;
	}

	public Ranks getRank() {
		return rank;
	}

	public void setRank(Ranks rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "PokerCard [suit=" + suit + ", rank=" + rank + "]";
	}
	
	

}
