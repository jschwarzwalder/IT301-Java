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
		CountListThread[] lineCountThreads = new CountListThread[fileNames.length];
		
		//start a thread for each of the files to count the lines
		for (int i = 0; i < lineCountThreads.length; i++){
			lineCountThreads[i] = new CountListThread("lists/" + fileNames[i]);
			lineCountThreads[i].start();
		}
		
		//join the lineCount Threads
		for (int i = 0; i < lineCountThreads.length; i++){
			try {
				lineCountThreads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//print out the line counts
		for (int i = 0; i < lineCountThreads.length; i++){
			System.out.println("lists/" + fileNames[i] + ": " + lineCountThreads[i].getLineCount());
		}
		
		//Search for word inside files
		WordSearchThread[] wordSearchThreads = new WordSearchThread[fileNames.length];
		
		//start a thread for each of the files to count the lines
		for (int i = 0; i < wordSearchThreads.length; i++){
			wordSearchThreads[i] = new WordSearchThread("lists/" + fileNames[i], "banana");
			wordSearchThreads[i].start();
		}
	
	}
}
