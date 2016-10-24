package edu.greenriver.it.sychronization;

public class SynchronizationDriver {

	public static void main(String[] args) throws InterruptedException {
		//create our shared data
		SharedData data = new SharedData();
		
		//create and start my thread
		CounterThread thread = new CounterThread(data);
		thread.start();
		
		//will wait for our secondary thread to complete
		thread.join();
		
		//print the data in shared data
		System.out.println(data.getCount());
		

	}

}
