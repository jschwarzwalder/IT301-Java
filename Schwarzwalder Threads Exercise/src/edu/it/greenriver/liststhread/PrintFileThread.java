/**
 * Jami Schwarzwalder
 * Oct 21, 2016
 * PrintFileThread.java
 * Prints a list of file names in lists folder
 */
package edu.it.greenriver.liststhread;

import java.io.File;

/**
 * Print out the names of all the files in the lists directory.
 * 
 * @author Jami Schwarzwalder
 * @version 1.1
 */
public class PrintFileThread extends Thread{
	
	public void run(){
		File lists_directory = new File("lists/");
		
		String[] fileNames = lists_directory.list();
		
		for (int i = 0; i < fileNames.length; i++){
			System.out.println("Found file: " + fileNames[i]);
		}
		
	}
	
	

}
