/*
 * Jami Schwarzwalder
 * 9/24/2016 
 * PlayingCard.java
 * Generic Playing Card Class
 */

package edu.greenriver.jschwarzwalder.CardShuffle;

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
	
	/**
	 * Returns the String value of the current color of the card
	 * 
	 * @return String The current color of card
	 */
	public String getColor() {
		return color;
	}
	
	/**
	 * This will change the string value for the color of the card
	 * 
	 * @param color a string that represents color of card
	 */
	public void setColor(String color) {
		this.color = color;
	}
	
	/**
	 * Returns the int value of the current width of the card
	 * 
	 * @return int The current width of card
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * This will change the int value for the width of the card
	 * 
	 * @param width a number that represents width of card
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	
	/**
	 * Returns the int value of the current height of the card
	 * 
	 * @return int The current height of card
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * This will change the int value for the height of the card
	 * 
	 * @param height a number that represents height of card
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	/**
	 * Creates human readable description of card including color, height and width
	 * 
	 * @return String that identifies color, height, and width of card
	 */
	
	public String toString(){
		String cardString ="This card is " + color + " , " + height + " tall, and " + width + " wide.";
		return cardString;
	}
	


}
