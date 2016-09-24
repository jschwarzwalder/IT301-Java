/*
 * Jami Schwarzwalder
 * 9/22/2016 
 * PlayingCard.java
 * Generic Playing Card Class
 */

package edu.greenriver.jschwarzwalder.Blackjack;

public class PlayingCard {
	private String color;
	private int width;
	private int height;
	
	/**
     * Creates a new Playing card with color, width and height 
     * 
     * @param mColor the name of the card color
     * @param mWidth the width of the playing card
     * @param mHeight the height of the playing card
     * 
     */
	public PlayingCard(String mColor, int mWidth, int mHeight ) {
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
