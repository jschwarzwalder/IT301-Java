package edu.greenriver.it.producer_consumer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Producer extends Thread
{
	private String fileName;
	
	public Producer(String fileName)
	{
		this.fileName = fileName;
	}
	
	@Override
	public void run()
	{
		try (Scanner scanner = new Scanner(new FileInputStream(fileName)))
		{
			//loop through my file and add words to the WordQueue
			while (scanner.hasNextLine())
			{
				String line = scanner.nextLine();
				
				
			}
		} 
		catch (FileNotFoundException e)
		{
			System.out.println("File not found: " + e.getMessage());
		}
	}
}
