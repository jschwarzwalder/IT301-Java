/**
 * Jami Schwarzwalder
 * Nov 6, 2016
 * LoadListThead.java
 * Reads User data from CSV File
 */
package edu.greenriver.it.list;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.greenriver.it.console.Console;
import edu.greenriver.it.userrecords.User;
import edu.greenriver.it.userrecords.UserRecords;

/**
 * Accepts a file using the CSV file format, 
 * reads the file line by line and
 * generates User objects that are then 
 * passed to the map in the User Records component.
 * 
 * @author Jami Schwarzwalder
 * @version 1.1
 */
public class LoadListThread extends Thread {

	private String listName;
	private UserRecords userRecords;

	public LoadListThread(String listName, UserRecords userRecords) {
		this.listName = "user_lists/" + listName;
		this.userRecords = userRecords;
	}

	public void run() {
		File fileToRead = new File(listName);
		Console.print("Scanning " + listName);
		Scanner fileScanner = null;
		int recordCount = 0;
		try {
			fileScanner = new Scanner(fileToRead);
			
			
			
			// remove header
			fileScanner.nextLine();

			while (fileScanner.hasNextLine()) {

				String userString = fileScanner.nextLine();

				// use String.split()
				String[] userData = userString.split(",");

				// create user Object from line
				User newUser = new User();
				newUser.setFirstName(userData[0].trim());
				newUser.setLastName(userData[1].trim());
				newUser.setSexAtBirth(userData[2].trim().charAt(0));
				newUser.setEmail(userData[3].trim());

				// build new Address with street, city, state, and zipcode
				newUser.setAddress(userData[4].trim(), userData[5].trim(), userData[6].trim(), userData[7].trim());

				newUser.setReferredFrom(userData[8].trim());
				newUser.setIsPreferredUser(Boolean.parseBoolean(userData[9].trim()));

				userRecords.addUser(newUser);
				
				recordCount ++;
				

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} finally {
			if (fileScanner != null) {
				fileScanner.close();
			}
		}
		
		Console.print("Completed scan of "+ listName + ", loaded"+ recordCount  +" records");

	}

}
