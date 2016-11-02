package edu.greenriver.it.synchronization;

public class SharedData
{
	private int count;
	
	public SharedData()
	{
		//do nothing
	}
	
	public void increment()
	{
		synchronized (this)
		{
			count++; //alter our data
		}
	}
	
	public int getCount()
	{
		return count;
	}
}
