package edu.greenriver.it.subsets;

public class BitArray {
	
	private static final int MAX_BITS = 32;
	//we will allow a user to interact with 31/32 bits
	private int data;
	
	//constructors
	public BitArray(){
		//all our bits are false
		data = 0;
	}
	
	//methods...
	public void setBoolean(int position, boolean value){
		
		
	}
	
	public boolean getBoolean(int position){
		//preconditions (must be true before you begin)
		if (position < 0 || position > MAX_BITS - 1){
			throw new IllegalArgumentException("Invalid bit position given");
		}
		
		
		//mask out the bit at the "position" given
		int mask = (int) Math.pow(2, position);
		int result = data & mask;
		
		//what to ask?
		//return result != 0
		
		if (result != 0){
			return true;	
		} else {
			return false;
		}
	}

}
