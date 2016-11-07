/**
 * Jami Schwarzwalder
 * Nov 6, 2016
 * LoadListThreadDriver.java
 * Test Load List Thread
 */
package edu.greenriver.it.driver;

import edu.greenriver.it.list.LoadListThread;
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
		String fileName = "users_list_5.csv";

		LoadListThread user_list_thread_5 = new LoadListThread(fileName, records);
		user_list_thread_5.run();
		user_list_thread_5.join();
		
		System.out.println(records.toString());
		
		

	}

}
