/**
 * Jami Schwarzwalder
 * Oct 22, 2016
 * CountListThread.java
 * Stores the name of a file in your "lists" directory
 */
package edu.it.greenriver.liststhread;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Stores the name of a file in your "lists" directory
 *
 * @author Jami Schwarzwalder
 * @version 1.1
 */
public class CountListThread extends Thread {

	private String listName;

	public CountListThread(String listName) {
		this.listName = listName;
	}

	@Override
	public void run() {

		// count the lines in the file "listName"
		File fileToRead = new File(listName);
		Scanner fileScanner;
		try {
			fileScanner = new Scanner(fileToRead);

			int numOfLines = 0;
			while (fileScanner.hasNextLine()) {

				fileScanner.nextLine();
				numOfLines += 1;

			}

			System.out.println(listName + " : " + numOfLines);
			fileScanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
