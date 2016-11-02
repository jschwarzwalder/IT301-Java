package edu.greenriver.it.thread_safety;


public class ArrayListTest
{
	public static void main(String[] args) throws InterruptedException
	{
		//test if the array list is thread safe
		SafeArrayList numbers = new SafeArrayList();
		
		Thread[] aFewThreads = new Thread[8];
		
		//create threads
		for (int i = 0; i < aFewThreads.length; i++)
		{
			aFewThreads[i] = createCountingThread(numbers);
		}
		
		//start threads
		for (int i = 0; i < aFewThreads.length; i++)
		{
			aFewThreads[i].start();
		}
		
		//wait for threads
		for (int i = 0; i < aFewThreads.length; i++)
		{
			aFewThreads[i].join();
		}
		
		//see results
		System.out.println(numbers.size());
	}
	
	public static Thread createCountingThread(SafeArrayList numbers)
	{
		Thread thread = new Thread(new Runnable() {
			public void run()
			{
				for (int i = 1; i <= 10000; i++)
				{
					numbers.add(i);
				}
			}
		});
		
		return thread;
	}
}
