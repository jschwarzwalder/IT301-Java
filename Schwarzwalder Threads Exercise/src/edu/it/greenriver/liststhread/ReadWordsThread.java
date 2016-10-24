/**
 * Jami Schwarzwalder
 * Oct 23, 2016
 * ReadWordsThread.java
 * Adds each line of the file to the shared data
 */
package edu.it.greenriver.liststhread;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Adds each line of the file to shared data
 * 
 * @author Jami Schwarzwalder
 * @version 1.1
 */
public class ReadWordsThread extends Thread {
	private String fileName;
	
	public ReadWordsThread(String fileName){
		this.fileName = fileName;
	}
	
	/**
	 * Adds each line of the file to the shared data
	 * 
	 */
	public void run(){
		File fileToRead = new File(fileName);
		Scanner fileScanner;
		try {
			fileScanner = new Scanner(fileToRead);
			
			while (fileScanner.hasNextLine()) {

				SharedData.add(fileScanner.nextLine());
			}

			fileScanner.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}
}
