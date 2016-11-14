/**
 * Jami Schwarzwalder
 * Nov 13, 2016
 * SharedPageQueue.java
 * [Description Here]
 */
package edu.greenriver.it.queue;

import java.util.LinkedList;

/**
 *
 * @author Jami Schwarzwalder
 * @version 1.1
 */
public class SharedPageQueue {
	
	LinkedList<String> pageQueue = new LinkedList<String>();
	int pagesDownload = 0;
	
	/**
	 * Adds a new page to the queue. The queue should have a maximum size of
	 * 50000.
	 * 
	 * If there is no room on the queue, then the thread should call wait() on
	 * the queue.
	 * 
	 * After adding a new page to the queue, you should call notify() on the
	 * queue.
	 * 
	 * 
	 * @param pageText
	 */
	public void addPages(String pageText) {
		if (pageQueue.size() < 50000){
			pageQueue.add(pageText);
			pagesDownload++;
			notify();
			
		} else {
			wait();
		}

	}

	/**
	 * Returns a page from the queue. If the queue is empty, then the thread
	 * should call wait() on the queue.
	 * 
	 * After removing a page from the queue, you should call notify() on the
	 * queue before returning the page text.
	 * 
	 * @return a page from the queue
	 */
	public String getNextPage() {
		if (pageQueue.size() > 0){
			String nextPage = pageQueue.remove(0);
			notify();
			return nextPage;
			
		} else {
			wait();
		}
	}

	/**
	 * This method returns the total number of pages that have been added to the
	 * queue through the addPage() method.
	 * 
	 * @return
	 */
	public int getPagesDownloaded() {
		
		return pagesDownload;

	}

}
