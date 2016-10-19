/**
 * Jami Schwarzwalder
 * Oct 19, 2016
 * TimedStoryBook.java
 * [Description Here]
 */
package edu.it.greenriver.storybook;


public class TimedStoryBook extends Thread{
	
	private Thread story; 
	
	public TimedStoryBook(Thread story){
		this.story = story; 
	}
	
	public void run(){
		System.out.println("Welcome to my Storybook!");
		
		try {
			Thread.sleep(2000);
			System.out.print("The story began long, long ago");
			
			for(int i = 1; i <= 10; i++){
				System.out.print(".");
				Thread.sleep(500);
			}
		}
		
		catch(InterruptedException interrupt) {
			
		}
		
		System.out.println();
	}	
}
