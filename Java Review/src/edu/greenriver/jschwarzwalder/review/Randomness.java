package edu.greenriver.jschwarzwalder.review;

import java.util.Random;

public class Randomness {

	private static Random myRandom = new Random();
	

	
	//return "heads" or "tails"
	public static String flipACoin() {

		
		//flip the coin...
		if (myRandom.nextBoolean()){
			return "heads";
		} else {
			return "tails";
		}
	}

}
