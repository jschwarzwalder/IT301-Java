package edu.greenriver.jschwarzwalder.Blackjack;

public class PlayingCards {
	private String color;
	private int width;
	private int height;
	
	public PlayingCards(String mColor, int mWidth, int mHeight ) {
		color = mColor;
		width = mWidth;
		height = mHeight;
		
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	public String toString(){
		String cardString ="This card is " + color + " , " + height + " tall, and " + width + " wide.";
		return cardString;
	}
	


}
