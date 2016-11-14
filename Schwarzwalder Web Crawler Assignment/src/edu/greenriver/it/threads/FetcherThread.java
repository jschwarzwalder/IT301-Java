/**
 * Jami Schwarzwalder
 * Nov 13, 2016
 * FetcherThread.java
 * [Description Here]
 */
package edu.greenriver.it.threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import edu.greenriver.it.queue.SharedLinkQueue;
import edu.greenriver.it.queue.SharedPageQueue;

/**
 *
 * @author Jami Schwarzwalder
 * @version 1.1
 */
public class FetcherThread extends Thread {
	private SharedLinkQueue searchList;
	private SharedPageQueue pageList;
	private static int failedDownloads;
	

	/**
	 * Creates a new FetcherThread
	 *
	 * @param searchList
	 * @param pageList
	 */
	public FetcherThread(SharedLinkQueue searchList, SharedPageQueue pageList) {
		this.searchList = searchList;
		this.pageList = pageList;
	}

	/**
	 * Performs searches while there are links in the queue. When queue is empty
	 * waits for new names.
	 * 
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		while (true) {
			
			// pull a link from the link queue
			String nextUrl = searchList.getNextLink();

			// download the (HTML) page text at the given URL
			BufferedReader download = downloadPageContent(nextUrl);

			// store the (HTML) page text on the page queue as a string
			if (download != null)
			{
				readFromBufferedReader(download);
			}

		}
		
	}

	private BufferedReader downloadPageContent(String nextUrl) {
		URL url = null;
		try {
			url = new URL(nextUrl);
		} catch (MalformedURLException e1) {
			System.out.println(e1.toString());
			synchronized(FetcherThread.class){
				failedDownloads ++;
			}
			return null;
		}
		
		HttpURLConnection connection;
		BufferedReader download = null;
		try {
			connection = (HttpURLConnection) url.openConnection();
			download = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		} catch (IOException e1) {
			System.out.println(e1.toString());
			synchronized(FetcherThread.class){
				failedDownloads ++;
			}
		}
		return download;
	}

	private void readFromBufferedReader(BufferedReader download) {
		StringBuilder htmlPageContent = new StringBuilder();
		String line;
		try {
			line = download.readLine();
			while (line != null) {
				htmlPageContent.append(line);
				line = download.readLine();
			}
			pageList.addPages(htmlPageContent.toString().toLowerCase());
		} catch (IOException e) {
			System.out.println(e.toString());
			synchronized(FetcherThread.class){
				failedDownloads ++;
			}
		}
	}

	public static int getFailedDownloads() {
		return failedDownloads;
	}


	

}
