/**
 * Jami Schwarzwalder
 * Dec 2, 2016
 * Interval1D.java
 * Print intersects from two ints
 */
package edu.greenriver.it.dataStructures;

import edu.greenriver.it.console.Console;

/**
 * 1.2.2 Takes an int value N as command-line argument, reads N intervals (each
 * defined by a pair of double values) from standard input, and prints all pairs
 * that intersect
 *
 * @author Jami Schwarzwalder
 * @version 1.1
 */
public class Interval1D {
	private double min;
	private double max;

	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		Interval1D[] intervals = new Interval1D[N];
		for (int i = 0; i < N; i++) {
			double min = Console.getDouble("Please enter first double of the pair");
			double max = Console.getDouble("Enter the second double of the pair");
			intervals[i] = new Interval1D(min, max);
		}
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				if (intervals[i].overlaps(intervals[j])){
					System.out.println(intervals[i] + " intersects "+ intervals[j]);
				}
			}
		}
			

	}

	private Interval1D(double min, double max) {
		this.min = min;
		this.max = max;

	}

	private boolean overlaps(Interval1D thatOne){
		if (this.min > thatOne.max){
			return false;
		} else if (this.max < thatOne.min){
			return false;
		} else {
			return true;
		}
	}
	
	public String toString(){
		return "[" + min + ", " + max + "]";
	}

}
