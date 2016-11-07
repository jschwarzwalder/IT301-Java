/**
 * Jami Schwarzwalder
 * Nov 6, 2016
 * SearchList.java
 * [Description Here]
 */
package edu.greenriver.it.list;

import java.util.LinkedList;

/**
 *
 * @author Jami Schwarzwalder
 * @version 1.1
 */
public class SearchList {

	LinkedList<String> usersToQuery;

	/**
	 * Adds a single name to the search queue tail
	 * 
	 * @param fullname
	 */
	public void search(String fullname) {
		usersToQuery.add(fullname);
		usersToQuery.notify();
	}

	/**
	 * Adds several names to the queue separated by commas
	 * 
	 * @param fullNames
	 */
	public void searchMultiple(String fullNames) {
		String[] multipleUsers = fullNames.split(",");
		for (String name : multipleUsers){
			search(name.trim());
		}
	}

	/**
	 * Perform search on lookup thread
	 * 
	 * @return a name to perform a search
	 */
	public String getSearch() {
		if (usersToQuery.size() == 0){
			try {
				usersToQuery.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println("Still waiting on queue");
				return this.getSearch();
			}
		} 
		
		return usersToQuery.removeFirst();
		
		
	}

}
