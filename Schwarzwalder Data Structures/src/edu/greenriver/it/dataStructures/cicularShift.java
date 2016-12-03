/**
 * Jami Schwarzwalder
 * Dec 2, 2016
 * cicularShift.java
 * Detects a circular shift
 */
package edu.greenriver.it.dataStructures;

/**
 * 1.2.6 A string s is a circular shift of string t if it matches when the
 * characters are circularly shifted by any number of positions
 * 
 * Progrem that checks whether two given strings are circular shifts of one another.
 *
 * @author Jami Schwarzwalder
 * @version 1.1
 */
public class cicularShift {
	
	public boolean isACircularShift (String s, String t){
		 
		String sequence = s + s;
		if (sequence.indexOf(t) > -1){
			return true;
		}
		return false;
		
	}

}
