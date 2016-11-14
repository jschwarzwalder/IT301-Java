/**
 * Jami Schwarzwalder
 * Nov 13, 2016
 * LinkQueue.java
 * [Description Here]
 */
package edu.greenriver.it.queue;

import java.util.LinkedList;

/**
 *
 * @author Jami Schwarzwalder
 * @version 1.1
 */
public class LinkQueue {

	/**
	 * Perform search on lookup thread
	 * 
	 * @return a name to perform a search
	 */
	public String getSearch() {
		if (usersToQuery.size() == 0) {
			try {
				synchronized (usersToQuery) {
					usersToQuery.wait();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println("Still waiting on queue");
				return this.getSearch();
			}
		}

		return usersToQuery.removeFirst();
	}

	LinkedList<String> usersToQuery = new LinkedList<String>();

	/**
	 * Adds a single name to the search queue tail
	 * 
	 * @param fullname
	 *            first and last name of user to search for
	 */
	public void search(String fullname) {
		usersToQuery.add(fullname);
		synchronized (usersToQuery) {
			usersToQuery.notify();
		}
	}

}
