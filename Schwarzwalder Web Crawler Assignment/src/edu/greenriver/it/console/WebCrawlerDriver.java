/**
 * Jami Schwarzwalder
 * Nov 13, 2016
 * WebCrawlerDriver.java
 * [Description Here]
 */
package edu.greenriver.it.console;

import edu.greenriver.it.queue.SharedLinkQueue;

/**
 *
 * @author Jami Schwarzwalder
 * @version 1.1
 */
public class WebCrawlerDriver {


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
			Console.print("x. Exit");

			char choice = Console.getChar("Enter a choice");

			if (choice == '1') {
				//For this option you should prompt the user for a url, which is then added to the link queue.
				String userURL = Console.getString("Enter a url");
				SharedLinkQueue searchFor = new SharedLinkQueue();
				searchFor.addLink(userURL);
				
			} else if (choice == '2') {
				//Creates and starts a new Parse (consumer) thread. 
				//If there are no pages on the page queue, this will result in the thread going to sleep with a called to wait().

			} else if (choice == '3') {
				//Creates and starts a new Fetch (producer) thread. 
				//If there are no links on the link queue, this will result in the thread going to sleep with a called to wait().
				
			} else if (choice == '4') {
				//This menu option creates a new keyword that consumer threads can look for when parsing documents.
				//Your program should maintain a List of keywords that each consumer can access.


			}else if (choice == '5') {
				//Choosing this menu option will print out the following details of the web crawler:
				Console.print("Keywords found: " );
				Console.print("Links found: " + getLinksFound());
				Console.print("Pages found: " + getPagesDownloaded() );
				Console.print("Failed downloads: " );
				Console.print("Producers: " );
				Console.print("Consumers: " );
			
			} else{
				Console.print("Please enter a valid option.\n");;
			}
			Console.print("\n");
			
	
		}

	}

}
