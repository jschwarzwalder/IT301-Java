/**
 * Jami Schwarzwalder
 * Nov 13, 2016
 * WebCrawlerDriver.java
 * [Description Here]
 */
package edu.greenriver.it.console;

import java.util.LinkedList;

import edu.greenriver.it.queue.SharedLinkQueue;
import edu.greenriver.it.queue.SharedPageQueue;
import edu.greenriver.it.threads.FetcherThread;
import edu.greenriver.it.threads.ParserThread;

/**
 *
 * @author Jami Schwarzwalder
 * @version 1.1
 */
public class WebCrawlerDriver {
	private static LinkedList<String> keywordsList = new LinkedList<String>();
	private static SharedLinkQueue searchFor = new SharedLinkQueue();
	private static SharedPageQueue pageList = new SharedPageQueue();
	private static int consumerThreadsStarted;
	private static int producerThreadStarted;

	/**
	 * Prompts for loading file or searching inside records
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		while (true) {
			Console.print("1. Add seed url");
			Console.print("2. Add consumer");
			Console.print("3. Add producer");
			Console.print("4. Add keyword Search");
			Console.print("5. Print stats");

			char choice = Console.getChar("Enter a choice");

			if (choice == '1') {
				// For this option you should prompt the user for a url, which
				// is then added to the link queue.
				String userURL = Console.getString("Enter a url");
				searchFor.addLink(userURL);

			} else if (choice == '2') {
				// Creates and starts a new Parse (consumer) thread.
				// If there are no pages on the page queue, this will result in
				// the thread going to sleep with a called to wait().

				ParserThread consumerThread = new ParserThread(searchFor, pageList, keywordsList);
				consumerThread.start();
				consumerThreadsStarted++;

			} else if (choice == '3') {
				// Creates and starts a new Fetch (producer) thread.
				// If there are no links on the link queue, this will result in
				// the thread going to sleep with a called to wait().

				FetcherThread producerThread = new FetcherThread(searchFor, pageList);
				producerThread.start();
				producerThreadStarted++;

			} else if (choice == '4') {
				// This menu option creates a new keyword that consumer threads
				// can look for when parsing documents.
				// Your program should maintain a List of keywords that each
				// consumer can access.
				String keyword = Console.getString("Enter a keyword to search for").toLowerCase();
				if (!keywordsList.contains(keyword)) {
					keywordsList.add(keyword);
				}

			} else if (choice == '5') {
				// Choosing this menu option will print out the following
				// details of the web crawler:
				Console.print("Keywords found: " + ParserThread.getNumKeywordsFound());
				Console.print("Links found: " + searchFor.getLinksFound());
				Console.print("Pages found: " + pageList.getPagesDownloaded());
				Console.print("Failed downloads: " + FetcherThread.getFailedDownloads());
				Console.print("Producers: " + producerThreadStarted);
				Console.print("Consumers: " + consumerThreadsStarted);

			} else {
				Console.print("Please enter a valid option.\n");
				;
			}
			Console.print("\n");

		}

	}

}
