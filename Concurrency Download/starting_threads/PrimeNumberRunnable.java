package edu.greenriver.it.starting_threads;

public class PrimeNumberRunnable implements Runnable
{
	private int numberToCheck;
	
	public PrimeNumberRunnable(int numberToCheck)
	{
		this.numberToCheck = numberToCheck;
	}

	@Override
	public void run()
	{
		//determine if numberToCheck is prime
		for (int i = numberToCheck - 1; i >= 2; i--)
		{
			//is numberToCheck divisible by i
			if (numberToCheck % i == 0)
			{
				System.out.println(numberToCheck + " is not prime! " + 
			                       numberToCheck + " is divisible by " + i);
				return;
			}
		}
		
		System.out.println(numberToCheck + " is prime!");
	}
}
