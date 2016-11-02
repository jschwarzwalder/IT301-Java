package edu.greenriver.it.thread_safety;

import java.util.ArrayList;

//thread safe
public class SafeArrayList
{
	//no thread safe!
	private ArrayList<Integer> numbers;
	
	public SafeArrayList()
	{
		numbers = new ArrayList<Integer>();
	}
	
	public int get(int index)
	{
		synchronized (numbers)
		{
			return numbers.get(index);
		}
	}
	
	public int size()
	{
		synchronized (numbers)
		{
			return numbers.size();
		}
	}
	
	public synchronized void add(int value)
	{
		synchronized (numbers)
		{
			numbers.add(value);
		}
	}
}
