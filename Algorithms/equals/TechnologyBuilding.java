package edu.greenriver.it.equals;

public class TechnologyBuilding extends CampusBuilding
{
	public TechnologyBuilding(String campusName, String name, int squareFeet,
			                  String[] roomNames)
	{
		super(campusName, name, squareFeet, roomNames);
		
		//do nothing
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
		else if (!(other instanceof TechnologyBuilding))
		{
			return false;
		}
		else
		{
			//what do we know is true? we know this is a non-null
			//campus building object not equal to this building
			
			//compare fields for equality
			CampusBuilding otherBuilding = (CampusBuilding)other;
			
			return this.getName().equals(otherBuilding.getName());// &&
					//this.campusName.equals(otherBuilding.campusName);
		}
	}
}
