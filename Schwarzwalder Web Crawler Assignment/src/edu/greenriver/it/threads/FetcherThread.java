/**
 * Jami Schwarzwalder
 * Nov 13, 2016
 * FetcherThread.java
 * [Description Here]
 */
package edu.greenriver.it.threads;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;



/**
 *
 * @author Jami Schwarzwalder
 * @version 1.1
 */
public class FetcherThread extends Thread {
	private SearchList searchList;
	

	public LookupThread(SearchList searchList, UserRecords records) {
this.searchList=searchList;

	}

	/**
	 * Performs searches while there are links in the queue.  
	 * When queue is empty waits for new names.
	 * 
	 * @see java.lang.Thread#run()
	 */
	public void run(){
		while (true) {

		//pull a link from the link queue
			String url = searchList.getSearch();
			
		//download the (HTML) page text at the given URL
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		BufferedReader download = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		
		//store the (HTML) page text on the page queue as a string
	}
	
	

}
