/**
 * Jami Schwarzwalder
 * Oct 21, 2016
 * ListsDriver.java
 * Run the threads
 */
package edu.it.greenriver.liststhread;

/**
 * Makes and Runs the Threads
 *
 * @author Jami Schwarzwalder
 * @version 1.1
 */
public class ListsDriver {
	
	
	/**
	 * Makes and Runs the Threads
	 * 
	 * @param args
	 */
	public static void main (String[] args){
		Thread myThread = new PrintFileThread();
		System.out.println("Analyzing lists director ....");
		myThread.start();
	}
}
