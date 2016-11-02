package edu.greenriver.it.starting_threads;

public class TestThreads
{
	public static void main(String[] args)
	{
		createThreadOnTheFly();
	}
	
	public static void createThreadOnTheFly()
	{
		//create an anonymous class that uses the Runnable interface
		Thread myThread = new Thread(new Runnable() {
			public void run()
			{
				System.out.println("Hello world!");
			}
		});
		
		myThread.start();
	}
	
	public static void testRunnableInterface()
	{
		//Thread myThread = new Thread(new PrimeNumberRunnable(6401));
		//myThread.start();
		
		//check each of the following numbers
		int[] numbers = {7803, 495, 1967, 1337};
		Thread[] threads = new Thread[numbers.length];
		
		//create a thread for each number
		for (int i = 0;i < threads.length; i++)
		{
			threads[i] = new Thread(new PrimeNumberRunnable(numbers[i]));
		}
		
		//start all threads
		for (int i = 0;i < threads.length; i++)
		{
			threads[i].start();
		}
	}
	
	public static void testThreadClass()
	{
		Thread myThread = new CounterThread(1, 100);
		Thread anotherThread = new CounterThread(101, 200);
		myThread.start();
		anotherThread.start();
		
		for (int i = 1; i <= 100; i++)
		{
			System.out.println("main thread: " + i);
		}
	}
}
