/**
 * Jami Schwarzwalder
 * Nov 13, 2016
 * SharedLinkQueue.java
 * Stores list of URL for a web document
 */
package edu.greenriver.it.queue;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * Stores list of URL for a web document
 * 
 *
 * @author Jami Schwarzwalder
 * @version 1.1
 */
public class SharedLinkQueue {
	LinkedList<String> linkQueue = new LinkedList<String>();
	HashSet<String> seenUrls = new HashSet<String>();

	/**
	 * Adds a link to the queue if it has not yet been seen. This class should
	 * store a HashSet<String> of string URLs that have been seen so far. You
	 * should use to HashSet object to ensure that a link has not been added
	 * more than once.
	 * 
	 * The queue should have a maximum size of 50000. If there is no room on the
	 * queue, then the thread should call wait() on the queue.
	 * 
	 * After adding a new link to the queue, you should call notify() on the
	 * queue.
	 * 
	 * 
	 * 
	 * @param url
	 */
	public void addLink(String url) {
		synchronized (linkQueue) {
			if (linkQueue.size() < 50000) {
				if (!seenUrls.contains(url)) {
					linkQueue.add(url);
					linkQueue.notify();
				}
			} else {
				try {
					linkQueue.wait();
				} catch (InterruptedException e) {
					System.out.println(e.toString());
				}
			}
		}
	}

	/**
	 * Returns a link from the queue. If the queue is empty, then the thread
	 * should call wait() on the queue.
	 * 
	 * After removing a link from the queue, you should call notify() on the
	 * queue before returning the URL.
	 * 
	 * @return a link from the queue
	 */
	public String getNextLink() {
		
		synchronized (linkQueue) {
			if (linkQueue.size() > 0) {
				String nextLink = linkQueue.remove(0);
				linkQueue.notify();
				return nextLink;

			} else {
				try {
					linkQueue.wait();
					
				} catch (InterruptedException e) {
					System.out.println(e.toString());
				}
				return getNextLink();
			}
		}
	}

	/**
	 * This method returns the total number of unique links found so far through
	 * the use of the addLink() method.
	 * 
	 * @return
	 */
	public int getLinksFound() {
		return seenUrls.size();
	}
}
