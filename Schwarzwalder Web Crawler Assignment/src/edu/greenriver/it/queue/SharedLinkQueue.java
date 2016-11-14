/**
 * Jami Schwarzwalder
 * Nov 13, 2016
 * SharedLinkQueue.java
 * [Description Here]
 */
package edu.greenriver.it.queue;

import java.util.HashSet;
import java.util.LinkedList;

/**
 *
 * @author Jami Schwarzwalder
 * @version 1.1
 */
public class SharedLinkQueue {
	LinkedList<String> linkQueue = new LinkedList<String>();
	HashSet<String> seenUrls = new HashSet<String>();

	public void addLink(String url) {
		if (linkQueue.size() < 50000) {
			if (!seenUrls.contains(url)) {
				linkQueue.add(url);
				notify();
			}
		} else {
			wait();
		}
	}
	
	public String getNextLink(){
		if (linkQueue.size() > 0){
			String nextLink = linkQueue.remove(0);
			notify();
			return nextLink;
			
		} else {
			wait();
		}
	}
	
	public int getLinksFound(){
		return seenUrls.size();
	}
}
