/**
 * Jami Schwarzwalder
 * Nov 6, 2016
 * UserRecords.java
 * Map of all users
 */
package edu.greenriver.it.userrecords;

import java.util.HashMap;
import java.util.Map;

/**
 * Map of all Users
 *
 * @author Jami Schwarzwalder
 * @version 1.1
 */
public class UserRecords {

	Map<String, User> users = new HashMap<String, User>();

	/**
	 * Adds a new key/value pair to the map with full-name mapped to the User
	 * object
	 * 
	 * @param user
	 */
	public synchronized void addUser(User user) {

		String fullName = user.getFirstName() + " " + user.getLastName();
		users.put(fullName, user);
	}

	/**
	 * Returns true if there is a key in the map that matches fullName,
	 * otherwise false
	 * 
	 * @param fullName
	 * @return
	 */
	public synchronized boolean containsUser(String fullName) {
		return users.containsKey(fullName);
	}

	/**
	 * Returns the User object in the map that matches fullName
	 * 
	 * @param fullName
	 * @return
	 */
	public synchronized User getUser(String fullName) {
		return users.get(fullName);
	}

	/**
	 * Returns a readable String listing each User in User Records
	 * 
	 * @return
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (User user : users.values()) {

			stringBuilder.append(user.toString());
			stringBuilder.append("\n");
		}

		return stringBuilder.toString();
	}

}
