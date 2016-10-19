/**
 * Jami Schwarzwalder
 * Oct 19, 2016
 * StorybookDriver.java
 * [Description Here]
 */
package edu.it.greenriver.storybook;

/**
 *
 * @author Jami Schwarzwalder
 * @version 1.1
 */
public class StorybookDriver {
	public static void main(String[] args){
		
		Thread storyThread = new TimedStoryBook(Thread.currentThread());
		storyThread.start();
		
		try {
			storyThread.join();
			System.out.println("And they lived happily ever after!");
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
}
