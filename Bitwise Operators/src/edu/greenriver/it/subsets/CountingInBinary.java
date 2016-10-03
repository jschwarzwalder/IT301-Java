package edu.greenriver.it.subsets;

public class CountingInBinary {
	
	public static void main(String[] args){
		//print out 0-7 in binary
		for (int i = 0; i < 8; i++){
			printBinary(i,3);
		}
	}
	
	public static void printBinary(int number, int howManyBits) {
		//print number in binary
		int mask = 1;
		int result = number & mask;
		
		if (result == 0){ //the bit is "off" 
			System.out.print("0");
		} else { //the bit is "on"
			System.out.print("1");
		}
		
		//print new line
		System.out.println();
	}
}
