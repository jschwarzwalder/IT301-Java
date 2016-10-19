package edu.it.greenriver.charcount;

public class CharacterCounterMain {
	public static void main(String[] args){
		Thread tracker = new CharacterCounter();
		
		tracker.start();
	}
}
