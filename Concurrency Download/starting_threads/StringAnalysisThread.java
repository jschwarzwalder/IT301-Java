package edu.greenriver.it.starting_threads;

public class StringAnalysisThread extends Thread
{
	private String text;
	
	public StringAnalysisThread(String text)
	{
		this.text = text;
	}
	
	@Override
	public void run()
	{
		//analyze the text
		System.out.println(text);
		
		//stats - length, numeric digits?, upper/lowercase?
		System.out.println("Length: " + text.length());
		
		int digits = 0;
		int characters = 0;
		int upper = 0;
		int lower = 0;
		
		for (int i = 0; i < text.length(); i++)
		{
			char character = text.charAt(i);
			
			if (Character.isDigit(character))
			{
				digits++;
			}
			
			if (Character.isAlphabetic(character))
			{
				characters++;
			}
			
			if (Character.isUpperCase(character))
			{
				upper++;
			}
			
			if (Character.isLowerCase(character))
			{
				lower++;
			}
		}
		
		System.out.println("Numeric digits: " + digits);
		System.out.println("Alphabetic chars: " + characters);
		System.out.println("Lowercase: " + lower);
		System.out.println("Uppercase: " + upper);
	}
}
