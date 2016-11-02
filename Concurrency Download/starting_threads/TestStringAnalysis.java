package edu.greenriver.it.starting_threads;

public class TestStringAnalysis
{
	public static void main(String[] args)
	{
		Thread thread = new StringAnalysisThread(
				"1: Phenomenal Woman by Maya Angelou\n" + 
                "2: Where the Sidewalk Ends by Shel Silverstein\n" + 
                "3: If You Forget Me by Pablo Neruda\n" + 
                "4: I carry your heart with me by E. E. Cummings\n" + 
                "5: The Road Not Taken by Robert Frost");
		
		thread.start();
		
		//split up my work among several threads
		String[] poems = {"1: Phenomenal Woman by Maya Angelou\n",
				          "2: Where the Sidewalk Ends by Shel Silverstein\n",
				          "3: If You Forget Me by Pablo Neruda\n",
				          "4: I carry your heart with me by E. E. Cummings\n",
				          "5: The Road Not Taken by Robert Frost"};
		
		Thread[] workers = new Thread[poems.length];
		for (int i = 0; i < poems.length; i++)
		{
			workers[i] = new StringAnalysisThread(poems[i]);
		}
		
		for (int i = 0; i < workers.length; i++)
		{
			workers[i].start();
		}
	}
}
