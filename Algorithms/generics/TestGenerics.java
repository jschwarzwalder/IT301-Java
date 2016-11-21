package edu.greenriver.it.generics;

import java.awt.Rectangle;

public class TestGenerics
{
	public static void main(String[] args)
	{
		//storing a specific type
		CharacterStorage myCharacter = new CharacterStorage('c');
		System.out.println(myCharacter.getData());
		
		//storing any type
		ObjectStorage stringValue = new ObjectStorage("hello world!");
		ObjectStorage doubleValue = new ObjectStorage(100.10);
		ObjectStorage rectangle = new ObjectStorage(new Rectangle(10, 10, 30, 50));
		
		String objectValue = (String)stringValue.getData();
		System.out.println(objectValue.toString());
		
		//use generics instead (much better!)
		DataStorage<String> stringValue2 = new DataStorage<String>("hello world!");
		DataStorage<Double> doubleValue2 = new DataStorage<Double>(100.10);
		DataStorage<Rectangle> rectangle2 = new DataStorage<Rectangle>(
				                                   new Rectangle(10, 10, 30, 50));
		
		System.out.println(rectangle2.getData().getWidth());
	}
}
