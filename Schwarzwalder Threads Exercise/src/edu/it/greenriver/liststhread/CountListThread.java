/**
 * Jami Schwarzwalder
 * Oct 22, 2016
 * CountListThread.java
 * Counts the number of lines in given file.
 */
package edu.it.greenriver.liststhread;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Counts the number of lines in given file.
 *
 * @author Jami Schwarzwalder
 * @version 1.1
 */
public class CountListThread extends Thread {

	private String listName;
	private int lineCount = 0;

	/**
	 * Creates a new CountListThread
	 *
	 * @param listName
	 */
	public CountListThread(String listName) {
		this.listName = listName;
	}

	/**
	 * Counts the number of lines in given file.
	 * 
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {

		// count the lines in the file "listName"
		File fileToRead = new File(listName);
		Scanner fileScanner;
		try {
			fileScanner = new Scanner(fileToRead);

			
			while (fileScanner.hasNextLine()) {

				fileScanner.nextLine();
				lineCount += 1;

			}

			//System.out.println(listName + " : " + lineCount);
			fileScanner.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	}

	
	/**
	 * Returns the number of lines
	 * 
	 * @return number of lines in the file scanned
	 */
	public int getLineCount() {
		return lineCount;
	}


}
