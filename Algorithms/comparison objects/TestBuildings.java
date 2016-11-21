package edu.greenriver.it.comparisonobjects;

import java.util.Arrays;

public class TestBuildings
{
	public static void main(String[] args)
	{
		CampusBuilding salish = new CampusBuilding("Green River", 
				                "Salish Hall", 15000);
		CampusBuilding technology = new CampusBuilding("Green River", 
				                "Technology Center", 10000);
		CampusBuilding holman = new CampusBuilding("Green River", 
				                "Holman Library", 20000);
		CampusBuilding reading = new CampusBuilding("Green River", 
				                "Reading Center", 25000);
		
		//use Comparable<T> directly
		if (salish.compareTo(technology) < 0)
		{
			System.out.println(salish.toString() + " comes before " + technology.toString());
		}
		else if (salish.compareTo(technology) > 0)
		{
			System.out.println(salish.toString() + " comes after " + technology.toString());
		}
		else //if (salish.compareTo(technology) == 0)
		{
			System.out.println(salish.toString() + " is equal to " + technology.toString());
		}
		
		//group and sort our buildings
		CampusBuilding[] buildings = {salish, technology, holman, reading};
		Arrays.sort(buildings);
		
		for (CampusBuilding building : buildings)
		{
			System.out.println(building);
		}
	}
}
