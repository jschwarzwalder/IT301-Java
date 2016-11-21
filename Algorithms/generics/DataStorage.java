package edu.greenriver.it.generics;

public class DataStorage<T>
{
	private T data;
	
	public DataStorage(T character)
	{
		this.data = character;
	}
	
	public T getData()
	{
		return data;
	}
}
