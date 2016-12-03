/**
 * Jami Schwarzwalder
 * Dec 2, 2016
 * Parentheses.java
 * Prints wether parentheses are properly balanced
 */
package edu.greenriver.it.dataStructures;

import java.util.Stack;

import edu.greenriver.it.console.Console;

/**
 * Reads text in a text stream from standard input and used a stack to determine
 * wheter its parentheses are properly balanced.
 *
 * @author Jami Schwarzwalder
 * @version 1.1
 */
public class Parentheses {
	static Stack<Character> parentheses = new Stack<Character>();
	
	static String goodValues = "()[]{}";
	
	public static void main(String[] args) {
		
		char nextChar = Console.getChar("Enter the a Character to begin your text stream");
		while(goodValues.indexOf(nextChar)!= -1)
			if (addChar(nextChar)) {
				Console.print("True. Have a Cookie and ...");
				nextChar = Console.getChar("Enter the next Character in your text stream");
			} else {
				Console.print("False. That is not balanced.");
				break;
			}
	}

	private static boolean addChar(char value) {
		if (value == '(' || value == '{' || value == '[') {
			parentheses.push(value);
			return true;
		}
		char prev = parentheses.peek();
		if (prev == '(' && value == ')') {
			parentheses.pop();
			return true;
		} else if (prev == '[' && value == ']') {
			parentheses.pop();
			return true;
		} else if (prev == '{' && value == '}') {
			parentheses.pop();
			return true;
		} else {
			return false;
		}
	}
}