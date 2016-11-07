/**
 * Jami Schwarzwalder
 * Nov 6, 2016
 * LoadListThreadDriver.java
 * Test Load List Thread
 */
package edu.greenriver.it.driver;

import edu.greenriver.it.console.Console;
import edu.greenriver.it.list.LoadListThread;
import edu.greenriver.it.list.SearchList;
import edu.greenriver.it.userrecords.UserRecords;

/**
 *
 * @author Jami Schwarzwalder
 * @version 1.1
 */
public class LoadListThreadDriver {

	

	/**
	 * Test Load List Thread
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		UserRecords records = new UserRecords();
		SearchList listOfUsers = new SearchList();

		for (int i = 1; i <= 5; i++) {

			String fileName = "users_list_" + i + ".csv";

			LoadListThread user_list_thread = new LoadListThread(fileName, records);
			user_list_thread.run();
			user_list_thread.join();

			

		}

		Console.print("1. Load user list");
		Console.print("2. Search for user");
		Console.print("3. Search for multiple users");
		Console.print("99. Exit");
		
		int choice = Console.getInt("Enter a choice:");
		
		if (choice == 1){
			String listName = Console.getString("Enter a list name: ");
			
		} else if (choice == 2){
			String nameToSearchFor = Console.getString("Enter a full name: ");
			listOfUsers.search(nameToSearchFor);
			
		} else if (choice == 3){
			String multipleNamesToSearch = Console.getString("Enter several full names separated by commas: ");
			listOfUsers.searchMultiple(multipleNamesToSearch);
		}
		
		

	}

}
