/**
 * Jami Schwarzwalder
 * Nov 13, 2016
 * ParserThread.java
 * Goes through HTML and adds URLs to Queue
 */
package edu.greenriver.it.threads;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.greenriver.it.queue.SharedLinkQueue;
import edu.greenriver.it.queue.SharedPageQueue;

/**
 * Goes through HTML and adds URLs to Queue
 *
 * @author Jami Schwarzwalder
 * @version 1.1
 */
public class ParserThread extends Thread {

	private SharedLinkQueue searchList;
	private SharedPageQueue pageList;
	private LinkedList<String> keywordList;
	private static int numKeywordsFound = 0;

	/**
	 * Creates a new ParserThread
	 *
	 * @param searchList
	 * @param pageList
	 */
	public ParserThread(SharedLinkQueue searchList, SharedPageQueue pageList, LinkedList<String> keywordList) {

		this.searchList = searchList;
		this.pageList = pageList;
		this.keywordList = keywordList;
	}

	/**
	 * while page queue is not empty, find URLs, and add to link queue
	 * 
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		while (true) {

			// pull a page from the page queue
			String pageText = pageList.getNextPage();

			// search the page for all links in anchor (<a href="">) elements
			Pattern pattern = Pattern.compile("href=\"(http:.*?)\"");
			Matcher matcher = pattern.matcher(pageText);

			while (matcher.find()) {
				String link = matcher.group(1);

				// add each link found to the link queue
				searchList.addLink(link);
			}

			// search the page for any keywords specified by the user of the web
			// crawler (more on this later)
			for (String keyword : keywordList) {
				String[] keywordsFound = pageText.split(keyword);

				// keep track of how many keywords are encountered
				numKeywordsFound += keywordsFound.length - 1;
			}

		}
	}

	/**
	 * Return the total number of times a keyword is found.
	 * 
	 * @return
	 */
	public static int getNumKeywordsFound() {
		return numKeywordsFound;
	}

}
