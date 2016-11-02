package edu.greenriver.it.deadlock;

public class Friend
{
	private String name;
	
	public Friend(String name)
	{
		this.name = name;
	}
	
	//our lock is "this"
	public synchronized void bow(Friend other)
	{
		System.out.println(name + ": " + other.name + " has bowed to me!");
		
		other.bowBack(this);
	}
	
	public synchronized void bowBack(Friend other)
	{
		System.out.println(name + ": " + other.name + " has bowed back to me!");
	}
}
