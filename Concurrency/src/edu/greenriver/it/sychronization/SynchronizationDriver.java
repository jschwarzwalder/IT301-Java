package edu.greenriver.it.sychronization;

public class SynchronizationDriver {

	public static void main(String[] args) throws InterruptedException {
		//create our shared data
		SharedData data = new SharedData();
		
		//create and start my thread
		CounterThread[] threads = {new CounterThread(data),
									new CounterThread(data),
									new CounterThread(data) };
		
		for (int i = 0; i < threads.length; i++){
			threads[i].start();
		}
		
		//will wait for our secondary thread to complete
		for (int i = 0; i < threads.length; i++){
			threads[i].join();
		}
		
		//print the data in shared data
		System.out.println(data.getCount());
		

	}

}
