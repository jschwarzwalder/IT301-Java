package edu.greenriver.it.equals;

import java.util.Arrays;

public class CampusBuilding implements Comparable<CampusBuilding>
{
	//fields
	private String campusName;
	private String name;
	private int squareFeet;
	private String[] roomNames; //TC 120, TC 116, SH 110
	
	//constructors
	public CampusBuilding(String campusName, String name, int squareFeet, 
			              String[] roomNames)
	{
		this.campusName = campusName;
		this.name = name;
		this.squareFeet = squareFeet;
		this.roomNames = roomNames;
	}
	
	//methods
	public String getName()
	{
		return name;
	}
	
	@Override
	public boolean equals(Object other)
	{
		//nothing is equal to null
		if (other == null)
		{
			return false;
		}
		else if (this == other) //same memory address?
		{
			return true;
		}
		else if (!(this.getClass().equals(other.getClass())))
		{
			return false;
		}
		else
		{
			//what do we know is true? we know this is a non-null
			//campus building object not equal to this building
			
			//compare fields for equality
			CampusBuilding otherBuilding = (CampusBuilding)other;
			
			return this.name.equals(otherBuilding.name);// &&
					//this.campusName.equals(otherBuilding.campusName);
		}
	}

	@Override
	public String toString()
	{
		return "CampusBuilding [name=" + name + ", squareFeet=" + squareFeet
				+ ", roomNames=" + Arrays.toString(roomNames) + "]";
	}

	@Override
	public int compareTo(CampusBuilding otherBuilding)
	{
		//return negative (this < otherBuilding), positive (this > otherBuilding 
		//or zero (this == otherBuilding)
		
		//compare by building name
		return this.name.compareTo(otherBuilding.name); //String uses Comparable<String>
	}
}
