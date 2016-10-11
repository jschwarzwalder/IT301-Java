package edu.greenriver.it.recursion;

public class TestCallStack
{
	private static int methodCount = 0;
	
	public static void main(String[] args)
	{
		foo();
	}

	public static void foo()
	{
		int count = 1; 
		
		methodCount++;
		System.out.println("Method call: " + methodCount);
		foo();
	}
}
