/**
 * Jami Schwarzwalder
 * Oct 21, 2016
 * ListsDriver.java
 * Run the threads
 */
package edu.it.greenriver.liststhread;

import java.io.File;

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
		//print out list of the names of all files in lists directory
		Thread myThread = new PrintFileThread();
		System.out.println("Analyzing lists director ....");
		myThread.start();
		try {
			myThread.join();
			System.out.println("Done analyzing lists directory... ");
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		
		//Count number of lines in each file
		File lists_directory = new File("lists/");
		String[] fileNames = lists_directory.list();
		
		for (int i = 0; i < fileNames.length; i++){
			new CountListThread("lists/" + fileNames[i]).start();
		}
	}
}
