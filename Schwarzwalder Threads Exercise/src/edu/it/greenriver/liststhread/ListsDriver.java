/**
 * Jami Schwarzwalder
 * Oct 21, 2016
 * ListsDriver.java
 * Run the threads
 */
package edu.it.greenriver.liststhread;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

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
	public static void main(String[] args) {
		// print out list of the names of all files in lists directory
		Thread myThread = new PrintFileThread();
		System.out.println("Analyzing lists director ....");
		myThread.start();
		try {
			myThread.join();
			System.out.println("Done analyzing lists directory... ");
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		// Count number of lines in each file
		File lists_directory = new File("lists/");
		String[] fileNames = lists_directory.list();
		CountListThread[] lineCountThreads = new CountListThread[fileNames.length];

		// start a thread for each of the files to count the lines
		for (int i = 0; i < lineCountThreads.length; i++) {
			lineCountThreads[i] = new CountListThread("lists/" + fileNames[i]);
			lineCountThreads[i].start();
		}

		// join the lineCount Threads
		for (int i = 0; i < lineCountThreads.length; i++) {
			try {
				lineCountThreads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// print out the line counts
		for (int i = 0; i < lineCountThreads.length; i++) {
			System.out.println("lists/" + fileNames[i] + ": " + lineCountThreads[i].getLineCount());
		}

		// Search for word inside files
		WordSearchThread[] wordSearchThreads = new WordSearchThread[fileNames.length];

		// start a thread for each of the files to count the lines
		for (int i = 0; i < wordSearchThreads.length; i++) {
			wordSearchThreads[i] = new WordSearchThread("lists/" + fileNames[i], "banana");
			wordSearchThreads[i].start();
		}

		// Adds each line of the file to the shared data
		ReadWordsThread[] readWordsThreads = new ReadWordsThread[fileNames.length];

		// start a thread for each of the files to count the lines
		for (int i = 0; i < readWordsThreads.length; i++) {
			readWordsThreads[i] = new ReadWordsThread("lists/" + fileNames[i]);
			readWordsThreads[i].start();
		}

		// pause execution on the main thread until all secondary threads have
		// completed.
		for (int i = 0; i < readWordsThreads.length; i++) {
			try {
				readWordsThreads[i].join();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

		// Write a final loop that uses a PrintWriter object to write the
		// contents of your shared data to a file called master_list.txt.
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("master_list.txt");
			for (int i = 0; i < SharedData.wordPhraseTotal(); i++){
				writer.println(SharedData.getWordPhrase(i));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			writer.close();
		}
		
		CountListThread listThread = new CountListThread("master_list.txt");
		
		listThread.start();
		try {
			listThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(listThread.getLineCount());
	}
}
