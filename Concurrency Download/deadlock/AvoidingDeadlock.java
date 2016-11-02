package edu.greenriver.it.deadlock;

public class AvoidingDeadlock
{
	//some locks...
	private static Object lock1 = new Object();
	private static Object lock2 = new Object();
	
	public static void main(String[] args)
	{
		Thread[] threads = new Thread[10];
		
		for (int i = 0; i < threads.length; i++)
		{
			//alternate...
			if (i % 2 == 0)
			{
				threads[i] = createThreadOne("thread " + i);
			}
			else
			{
				threads[i] = createThreadTwo("thread " + i);
			}
		}
		
		//start threads...
		for (int i = 0; i < threads.length; i++)
		{
			threads[i].start();
		}
	}
	
	public static Thread createThreadOne(String name)
	{
		return new Thread(new Runnable() {
			public void run()
			{
				synchronized (lock1)
				{
					System.out.println(name + " gained lock 1");
					
					synchronized (lock2)
					{
						System.out.println(name + " gained lock 2");
					}
				}
			}
		});
	}
	
	public static Thread createThreadTwo(String name)
	{
		return new Thread(new Runnable() {
			public void run()
			{
				synchronized (lock2)
				{
					System.out.println(name + " gained lock 2");
					
					synchronized (lock1)
					{
						System.out.println(name + " gained lock 1");
					}
				}
			}
		});
	}
}
