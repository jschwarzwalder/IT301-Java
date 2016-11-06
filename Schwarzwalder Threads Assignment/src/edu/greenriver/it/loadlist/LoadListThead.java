/**
 * Jami Schwarzwalder
 * Nov 6, 2016
 * LoadListThead.java
 * Reads User data from CSV File
 */
package edu.greenriver.it.loadlist;

import java.io.File;

/**
 * Accepts a file using the CSV file format, 
 * reads the file line by line and
 * generates User objects that are then 
 * passed to the map in the User Records component.
 * 
 * @author Jami Schwarzwalder
 * @version 1.1
 */
public class LoadListThead extends Thread {
	
	private String listName;
	
	public LoadListThead(String listName) {
		this.listName = "user_lists/" + listName;
	}



	public void run(){
		File filetoRead = new File(listName);
		
	}

}
