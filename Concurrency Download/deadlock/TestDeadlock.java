package edu.greenriver.it.deadlock;

public class TestDeadlock
{

	public static void main(String[] args)
	{
		//friend objects
		Friend bob = new Friend("Bob");
		Friend susy = new Friend("Susy");
		
		//create a few threads
		Thread bobThread = new Thread(new Runnable() {
			public void run()
			{
				bob.bow(susy);
			}
		});
		
		Thread susyThread = new Thread(new Runnable() {
			public void run()
			{
				susy.bow(bob);
			}
		});
		
		//start them
		bobThread.start();
		susyThread.start();
	}

}
