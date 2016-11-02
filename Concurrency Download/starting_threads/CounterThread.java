package edu.greenriver.it.starting_threads;

public class CounterThread extends Thread
{
	//fields
	private int low;
	private int high;
	
	public CounterThread(int low, int high)
	{
		super();
		
		this.low = low;
		this.high = high;
	}
	
	@Override
	public void run()
	{
		for (int i = low; i <= high; i++)
		{
			System.out.println("counter thread: " + i);
		}
	}
}
