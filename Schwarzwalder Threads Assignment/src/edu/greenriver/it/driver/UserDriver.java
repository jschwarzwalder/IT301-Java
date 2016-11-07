/**
 * Jami Schwarzwalder
 * Nov 6, 2016
 * LoadListThreadDriver.java
 * Prompts for loading file or searching inside records
 */
package edu.greenriver.it.driver;

import edu.greenriver.it.console.Console;
import edu.greenriver.it.list.LoadListThread;
import edu.greenriver.it.list.LookupThread;
import edu.greenriver.it.list.SearchList;
import edu.greenriver.it.userrecords.UserRecords;

/**
 * Prompts for loading file or searching inside records
 *
 * @author Jami Schwarzwalder
 * @version 1.1
 */
public class UserDriver {

	/**
	 * Prompts for loading file or searching inside records
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		UserRecords records = new UserRecords();
		SearchList listOfUsers = new SearchList();

		Thread lookupThread = new LookupThread(listOfUsers, records);
		lookupThread.start();

		while (true) {
			Console.print("1. Load user list");
			Console.print("2. Search for user");
			Console.print("3. Search for multiple users");
			Console.print("x. Exit");

			char choice = Console.getChar("Enter a choice");

			if (choice == '1') {
				String listName = Console.getString("Enter a list name");
				LoadListThread user_list_thread = new LoadListThread(listName, records);
				user_list_thread.run();

			} else if (choice == '2') {
				String nameToSearchFor = Console.getString("Enter a full name ");
				listOfUsers.search(nameToSearchFor);

			} else if (choice == '3') {
				String multipleNamesToSearch = Console.getString("Enter several full names separated by commas ");
				listOfUsers.searchMultiple(multipleNamesToSearch);
			} else if (choice == 'x' || choice == 'X') {
				return;
			} else{
				Console.print("Please enter a valid option.\n");;
			}
			Console.print("\n");
			
	
		}

	}

}
