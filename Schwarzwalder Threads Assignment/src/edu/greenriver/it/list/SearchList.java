/**
 * Jami Schwarzwalder
 * Nov 6, 2016
 * SearchList.java
 * Maintains list of names that will be searched
 */
package edu.greenriver.it.list;

import java.util.LinkedList;

/**
 * Maintains list of names that will be searched
 *
 * @author Jami Schwarzwalder
 * @version 1.1
 */
public class SearchList {

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

	/**
	 * Adds several names to the queue separated by commas
	 * 
	 * @param fullNames
	 *            first and last names of users to search for separated by commas
	 */
	public void searchMultiple(String fullNames) {
		String[] multipleUsers = fullNames.split(",");
		for (String name : multipleUsers) {
			search(name.trim());
		}
	}

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

}
