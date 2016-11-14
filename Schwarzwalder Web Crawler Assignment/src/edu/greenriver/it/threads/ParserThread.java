/**
 * Jami Schwarzwalder
 * Nov 13, 2016
 * ParserThread.java
 * [Description Here]
 */
package edu.greenriver.it.threads;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.greenriver.it.queue.SharedLinkQueue;
import edu.greenriver.it.queue.SharedPageQueue;

/**
 *
 * @author Jami Schwarzwalder
 * @version 1.1
 */
public class ParserThread extends Thread {

	private SharedLinkQueue searchList;
	private SharedPageQueue pageList;
	private String keyword;
	private int numKeywordsFound;

	/**
	 * Creates a new ParserThread
	 *
	 * @param searchList
	 * @param pageList
	 */
	public ParserThread(SharedLinkQueue searchList, SharedPageQueue pageList) {

		this.searchList = searchList;
		this.pageList = pageList;
	}

	public void run() {
		while (true) {

			// pull a page from the page queue
			String pageText = pageList.getNextPage();

			// search the page for all links in anchor (<a href="">) elements
			Pattern pattern = Pattern.compile("href=\"((http:.*?)\"");
			Matcher matcher = pattern.matcher(pageText);

			while (matcher.find()) {
				String link = matcher.group(2);

				// add each link found to the link queue
				searchList.addLink(link);
			}

			// search the page for any keywords specified by the user of the web
			// crawler (more on this later)
			String[] keywordsFound = pageText.split(keyword);

			// keep track of how many keywords are encountered
			numKeywordsFound = keywordsFound.length;

		}
	}

}
