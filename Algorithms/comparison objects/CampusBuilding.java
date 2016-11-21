package edu.greenriver.it.comparisonobjects;

import java.util.Arrays;

public class CampusBuilding implements Comparable<CampusBuilding>
{
	//fields
	private String campusName;
	private String name;
	private int squareFeet;
	
	//constructors
	public CampusBuilding(String campusName, String name, int squareFeet)
	{
		this.campusName = campusName;
		this.name = name;
		this.squareFeet = squareFeet;
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
		return name + "(" + campusName + ") - " + squareFeet + " sq. ft.";
	}

	@Override
	public int compareTo(CampusBuilding otherBuilding)
	{
		//return negative (this < otherBuilding), positive (this > otherBuilding 
		//or zero (this == otherBuilding)
		
		//compare by building name
		//return this.name.compareTo(otherBuilding.name); //String uses Comparable<String>
		
		//compare by square feet
//		if (this.squareFeet < otherBuilding.squareFeet)
//		{
//			return -1;
//		}
//		else if (this.squareFeet > otherBuilding.squareFeet)
//		{
//			return 1;
//		}
//		else //if (this.squareFeet == otherBuilding.squareFeet)
//		{
//			return 0;
//		}
		
		//same as the calculation above...
		return this.squareFeet - otherBuilding.squareFeet;
	}
}
