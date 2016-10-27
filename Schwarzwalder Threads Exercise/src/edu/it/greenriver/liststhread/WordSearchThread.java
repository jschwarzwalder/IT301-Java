/**
 * Jami Schwarzwalder
 * Oct 22, 2016
 * WordSearchThread.java
 * Uses a Thread to look for a search term inside word list
 */
package edu.it.greenriver.liststhread;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Uses a Thread to look for a search term inside word list
 *
 * @author Jami Schwarzwalder
 * @version 1.1
 */
public class WordSearchThread extends Thread {
	
	private String wordList;
	private String searchTerm; 
	

	/**
	 * Creates a new WordSearchThread to look for a search term inside word list
	 *
	 * @param  word search thread that stores a file name
	 * @param  search term 
	 */
	public WordSearchThread(String wordList, String searchTerm) {
		this.wordList = wordList;
		this.searchTerm = searchTerm;
		
	}

	
	/**
	 * Searches word List for search term
	 * 
	 */
	public void run(){
		File fileToRead = new File(wordList);
		Scanner fileScanner = null;
		try {
			fileScanner = new Scanner(fileToRead);
			while (fileScanner.hasNextLine()) {
				String word = fileScanner.nextLine();
				if (word.equals(searchTerm)){
					System.out.println("\"" + searchTerm + "\" found in " + wordList);
				}
			}

			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} finally {
			if (fileScanner != null){
				fileScanner.close();
			}
		}
		
	}


}
