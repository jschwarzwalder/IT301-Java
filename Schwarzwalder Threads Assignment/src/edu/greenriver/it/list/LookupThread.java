/**
 * Jami Schwarzwalder
 * Nov 6, 2016
 * LookupThread.java
 * Searches for user in UserRecords
 */
package edu.greenriver.it.list;

import edu.greenriver.it.userrecords.UserRecords;

/**
 * Searches for user in UserRecords
 *
 * @author Jami Schwarzwalder
 * @version 1.1
 */
public class LookupThread extends Thread {
	private SearchList searchList;
	private UserRecords records;

	public LookupThread(SearchList searchList, UserRecords records) {

		this.searchList = searchList;
		this.records = records;
	}

	public void run() {
		// infinite loop
		while (true) {

			// pulls search values from the SearchList queue
			String nameToSearch = searchList.getSearch();

			// then searches for the specified user in the UserRecords
			if (records.containsUser(nameToSearch)) {

				// The thread should print out the User's toString() method or
				System.out.println(records.getUser(nameToSearch).toString());
			} else {

				// The thread should print out "user not found" if the user
				// record is not in the map.
				System.out.println("User not found");
			}

		}
	}

}
